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

  @Value("${conf.jsonplaceholder.endpoints.posts}")
  private String postsEndpoint;

  @Override
  public List<UserEntity> saveUser() {
    UserModel[] userModels = this.getUser();
    List<UserEntity> userEntitys = new ArrayList<>(userModels.length);
    for(UserModel user: userModels) {
      userEntitys.add(UserEntity.builder()
      .email(user.getEmail())
      .name(user.getName())
      .phone(user.getPhone())
      .userId(user.getUserid())
      .username(user.getUsername())
      .website(user.getWebsite())
      .build());
    }
    return userRepository.saveAll(userEntitys);
  }

  @Override
  public UserModel[] getUser() {
    return new RestTemplate().getForObject(UriComponentsBuilder.newInstance()
            .scheme(protocol)
            .host(host)
            .path(userEndpoint)
            .build()
            .toString(), UserModel[].class);
  }

  @Override
  public UserEntity updateUserId(Long userId, Long newUserId) {
    UserEntity userEntity = this.userRepository.findByUserId(userId).orElseThrow();
    userEntity.setUserId(newUserId);
    return this.userRepository.save(userEntity);
  }

  @Override
  public void deleteUser(Long userId) {
    UserEntity userEntity = this.userRepository.findByUserId(userId).orElseThrow();
    this.userRepository.delete(userEntity);
  }
}
