package com.kdkd.test_postcomments.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kdkd.test_postcomments.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long>{

}
