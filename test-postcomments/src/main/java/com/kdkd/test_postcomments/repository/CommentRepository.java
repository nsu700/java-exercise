package com.kdkd.test_postcomments.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdkd.test_postcomments.entity.CommentEntity;
import com.kdkd.test_postcomments.entity.PostEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
  List<CommentEntity> findAllByPostEntity(PostEntity postEntity);
}
