package com.kdkd.test_postcomments.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GeneralDto {
  private Long userid;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private List<PostDto> posts;

  @Getter
  @Builder
  public static class PostDto {
    private String title;
    private String body;
    private List<CommentDto> comments;

    @Getter
    @Builder
    public static class CommentDto {
      private String name;
      private String body;
    }
  }
}
