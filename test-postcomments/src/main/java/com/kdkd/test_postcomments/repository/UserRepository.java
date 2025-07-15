package com.kdkd.test_postcomments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdkd.test_postcomments.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
  UserEntity findByUserId(Long userId);
}
