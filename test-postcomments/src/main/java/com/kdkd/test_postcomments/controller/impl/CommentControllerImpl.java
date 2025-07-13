package com.kdkd.test_postcomments.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kdkd.test_postcomments.controller.CommentController;
import com.kdkd.test_postcomments.entity.CommentEntity;
import com.kdkd.test_postcomments.model.CommentModel;
import com.kdkd.test_postcomments.service.CommentService;

@RestController
public class CommentControllerImpl implements CommentController{
  @Autowired
  private CommentService commentService;

  @Override
  public CommentModel[] getComments() {
    return this.commentService.getComments();
  }

  @Override
  public List<CommentEntity> saveComments() {
    return this.commentService.saveComments();
  }
}
