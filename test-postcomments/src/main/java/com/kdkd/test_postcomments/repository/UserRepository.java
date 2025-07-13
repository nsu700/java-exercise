package com.kdkd.test_postcomments.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdkd.test_postcomments.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
  public Optional<UserEntity> findByUserId(Long userId);
}
