package com.kdkd.test_postcomments.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kdkd.test_postcomments.entity.CommentEntity;
import com.kdkd.test_postcomments.model.CommentModel;

@Controller
public interface CommentController {
  @GetMapping(value="/comments")
  CommentModel[] getComments();

  @PostMapping(value="/comments")
  List<CommentEntity> saveComments();
}
