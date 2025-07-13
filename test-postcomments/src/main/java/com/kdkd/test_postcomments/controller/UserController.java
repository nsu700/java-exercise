package com.kdkd.test_postcomments.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kdkd.test_postcomments.entity.UserEntity;
import com.kdkd.test_postcomments.model.UserModel;


@Controller
public interface UserController {
  @GetMapping(value="/users")
  UserModel[] getUsers();

  @PostMapping(value="/users")
  List<UserEntity> saveUsers();

  @PostMapping("/users/updateId")
  UserEntity updateUserId(@RequestParam Long userid, @RequestParam Long newuserid);

  @DeleteMapping("/users/delete")
  void deleteUser(@RequestParam Long userid);
}
