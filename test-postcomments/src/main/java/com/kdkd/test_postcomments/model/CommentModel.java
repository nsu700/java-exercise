package com.kdkd.test_postcomments.model;

import lombok.Getter;

@Getter
public class CommentModel {
  private String name;
  private String email;
  private String body;
  private Long postId;
}
