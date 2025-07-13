package com.kdkd.test_postcomments.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kdkd.test_postcomments.entity.PostEntity;
import com.kdkd.test_postcomments.model.PostModel;


@Controller
public interface PostController {
  @GetMapping(value="/posts")
  PostModel[] getPosts();

  @PostMapping(value="/posts")
  List<PostEntity> savePosts();
}
