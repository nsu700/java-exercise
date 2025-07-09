package com.kd.test_apicall.service;

import java.util.List;

import com.kd.test_apicall.entity.UserEntity;

public interface ApicallService {
  List<UserEntity> getAndSaveUsers();
}
