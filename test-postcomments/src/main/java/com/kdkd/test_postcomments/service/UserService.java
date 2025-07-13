package com.kdkd.test_postcomments.service;

import java.util.List;

import com.kdkd.test_postcomments.entity.UserEntity;
import com.kdkd.test_postcomments.model.UserModel;

public interface UserService {
  UserModel[] getUser();
  List<UserEntity> saveUser();
}
