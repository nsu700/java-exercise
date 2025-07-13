package com.kdkd.test_postcomments.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kdkd.test_postcomments.controller.PostController;
import com.kdkd.test_postcomments.entity.PostEntity;
import com.kdkd.test_postcomments.model.PostModel;
import com.kdkd.test_postcomments.service.PostService;

@RestController
public class PostControllerImpl implements PostController{

  @Autowired
  private PostService postService;

  @Override
  public PostModel[] getPosts() {
    return postService.getPosts();
  }

  @Override
  public List<PostEntity> savePosts() {
    return postService.savePosts();
  }
}
