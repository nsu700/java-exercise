package com.kd.test_apicall.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kd.test_apicall.controller.ApicallController;
import com.kd.test_apicall.entity.UserEntity;
import com.kd.test_apicall.service.ApicallService;

@RestController
public class ApicallControllerImpl implements ApicallController{

  @Autowired
  private ApicallService apicallService;

  @Override
  public List<UserEntity> getAndSaveUsers() {
    return this.apicallService.getAndSaveUsers();
  }
}
