package com.kdkd.test_postcomments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdkd.test_postcomments.entity.PostEntity;
import com.kdkd.test_postcomments.entity.UserEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{
  List<PostEntity> findAllByUserEntity(UserEntity userEntity);
}
