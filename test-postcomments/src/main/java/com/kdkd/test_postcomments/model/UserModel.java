package com.kdkd.test_postcomments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class UserModel {
  @JsonProperty("id") // Without this, the output field of userid would be null, cause there is no a userid field in the input json
  private Long userid;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
}
