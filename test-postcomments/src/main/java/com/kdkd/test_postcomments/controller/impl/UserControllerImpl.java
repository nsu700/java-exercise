package com.kdkd.test_postcomments.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kdkd.test_postcomments.controller.UserController;
import com.kdkd.test_postcomments.entity.UserEntity;
import com.kdkd.test_postcomments.model.UserModel;
import com.kdkd.test_postcomments.service.UserService;

@RestController
public class UserControllerImpl implements UserController{

  @Autowired
  private UserService userService;

  @Override
  public UserModel[] getUsers() {
    return userService.getUser();
  }

  @Override
  public List<UserEntity> saveUsers() {
    return userService.saveUser();
  }

  @Override
  public String greet() {
    return userService.greet();
  }
}
