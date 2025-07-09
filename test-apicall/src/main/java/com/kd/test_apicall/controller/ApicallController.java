package com.kd.test_apicall.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import com.kd.test_apicall.entity.UserEntity;

public interface ApicallController {
  @PostMapping(value = "/saveusers")
  List<UserEntity> getAndSaveUsers();
}
