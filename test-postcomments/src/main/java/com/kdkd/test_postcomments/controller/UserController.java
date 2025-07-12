package com.kdkd.test_postcomments.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kdkd.test_postcomments.entity.UserEntity;
import com.kdkd.test_postcomments.model.UserModel;

@Controller
public interface UserController {
  @GetMapping(value="/users")
  UserModel[] getUsers();

  @PostMapping(value="/users")
  List<UserEntity> saveUsers();

  @GetMapping(value="/greet")
  String greet();
}
