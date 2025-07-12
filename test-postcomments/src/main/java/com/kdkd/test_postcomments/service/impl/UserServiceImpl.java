package com.kdkd.test_postcomments.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.kdkd.test_postcomments.entity.UserEntity;
import com.kdkd.test_postcomments.model.UserModel;
import com.kdkd.test_postcomments.repository.UserRepository;
import com.kdkd.test_postcomments.service.UserService;

import jakarta.annotation.PostConstruct;


@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private UserRepository userRepository;

  @Value("${conf.jsonplaceholder.host}")
  private String host;

  @Value("${conf.protocol}")
  private String protocol; 

  @Value("${conf.jsonplaceholder.endpoints.users}")
  private String userEndpoint;
  
  // 2. Declare the field, but don't initialize it here
  private String userURL;

  // 3. This method will run after the @Value fields are populated
  @PostConstruct
  public void initURL() {
      System.out.println("Building User URL after properties are injected...");
      this.userURL = UriComponentsBuilder.newInstance()
          .scheme(protocol)
          .host(host)
          .path(userEndpoint)
          .build()
          .toUriString();
      System.out.println("Constructed URL: " + this.userURL);
  }

  @Override
  public List<UserEntity> saveUser() {
    UserModel[] userModels = new RestTemplate().getForObject(this.userURL, UserModel[].class);
    List<UserEntity> userEntitys = new ArrayList<>(userModels.length);
    for(UserModel user: userModels) {
      userEntitys.add(UserEntity.builder()
      .email(user.getEmail())
      .name(user.getName())
      .phone(user.getPhone())
      .userid(user.getUserid())
      .username(user.getUsername())
      .website(user.getWebsite())
      .build());
    }
    return userRepository.saveAll(userEntitys);
  }

  @Override
  public UserModel[] getUser() {
    return new RestTemplate().getForObject(userURL, UserModel[].class);
  }

  @Override
  public String greet() {
    return "hello";
  }
}
