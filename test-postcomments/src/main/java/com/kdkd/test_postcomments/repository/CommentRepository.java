package com.kdkd.test_postcomments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdkd.test_postcomments.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{

}
