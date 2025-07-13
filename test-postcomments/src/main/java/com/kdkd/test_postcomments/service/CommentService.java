package com.kdkd.test_postcomments.service;

import java.util.List;

import com.kdkd.test_postcomments.entity.CommentEntity;
import com.kdkd.test_postcomments.model.CommentModel;

public interface CommentService {
  CommentModel[] getComments();
  List<CommentEntity> saveComments();
}
