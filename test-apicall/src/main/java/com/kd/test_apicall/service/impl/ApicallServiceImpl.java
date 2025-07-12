package com.kd.test_apicall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.kd.test_apicall.entity.AddressEntity;
import com.kd.test_apicall.entity.UserEntity;
import com.kd.test_apicall.model.Address;
import com.kd.test_apicall.model.Users;
import com.kd.test_apicall.repository.AddressRepository;
import com.kd.test_apicall.repository.UsersRepository;
import com.kd.test_apicall.service.ApicallService;

@Service
public class ApicallServiceImpl implements ApicallService{

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Value("${conf.jsonplaceholder.host}")
  private String host;

  @Value("${conf.protocol}")
  private String protocol; 

  @Value("${conf.jsonplaceholder.endpoints.users}")
  private String userEndpoint;


  @Override
  public List<UserEntity> getAndSaveUsers() {
    String url = UriComponentsBuilder.newInstance()
      .scheme(protocol)
      .host(host)
      .path(userEndpoint)
      .build()
      .toUriString();
    Users[] users = new RestTemplate().getForObject(url, Users[].class);
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

  public List<AddressEntity> getAndSaveAddresses() {
    String url = UriComponentsBuilder.newInstance()
      .scheme(protocol)
      .host(host)
      .path(userEndpoint)
      .build()
      .toUriString();
    Address[] addresses = new RestTemplate().getForObject(url, Address[].class);
    List<AddressEntity> addressEntitys = new ArrayList<>(addresses.length);
    for(Address address: addresses) {
      addressEntitys.add(AddressEntity.builder()
        .city(address.getCity())
        .street(address.getStreet())
        .suit(address.getSuite())
        .zipcode(address.getZipcode())
        .build());
    }
    return addressRepository.saveAll(addressEntitys);
  }
}
