package com.kd.test_apicall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kd.test_apicall.entity.UserEntity;
import com.kd.test_apicall.model.Users;
import com.kd.test_apicall.repository.UsersRepository;
import com.kd.test_apicall.service.ApicallService;

@Service
public class ApicallServiceImpl implements ApicallService{

  @Autowired
  private UsersRepository usersRepository;

  @Value("${conf.jsonplaceholder.host}")
  private String host;

  @Value("${conf.protocol}")
  private String protocol; 

  @Value("${conf.jsonplaceholder.endpoints.users}")
  private String userEndpoint;

  @Override
  public List<UserEntity> getAndSaveUsers() {
    // URL url = UriComponentsBuilder.newInstance()
    //   .scheme(protocol)
    //   .host(host)
    //   .path(userEndpoint)
    //   .build()
    //   .toUri()
    //   .toURL();

    Users[] users = new RestTemplate().getForObject("https://"+host+userEndpoint, Users[].class);
    List<UserEntity> userEntitys = new ArrayList<>(users.length);
    for(Users user: users) {
      userEntitys.add(UserEntity.builder()
        .name(user.getName())
        .email(user.getEmail())
        .phone(user.getPhone())
        .userId(user.getId())
        .username(user.getUsername())
        .build());
    }
    return usersRepository.saveAll(userEntitys);
  }
}
