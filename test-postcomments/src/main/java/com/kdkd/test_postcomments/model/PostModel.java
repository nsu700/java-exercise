package com.kdkd.test_postcomments.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostModel {
    private String title;
    private String body;
    @JsonProperty("userId")
    private Long userid;
    @JsonProperty("id")
    private Long postid;
}
