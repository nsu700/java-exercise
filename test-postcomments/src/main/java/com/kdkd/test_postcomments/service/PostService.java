package com.kdkd.test_postcomments.service;

import java.util.List;

import com.kdkd.test_postcomments.entity.PostEntity;
import com.kdkd.test_postcomments.model.PostModel;

public interface PostService {
  PostModel[] getPosts();
  List<PostEntity> savePosts();
}
