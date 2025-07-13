package com.kdkd.test_postcomments.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.kdkd.test_postcomments.entity.CommentEntity;
import com.kdkd.test_postcomments.entity.PostEntity;
import com.kdkd.test_postcomments.model.CommentModel;
import com.kdkd.test_postcomments.repository.CommentRepository;
import com.kdkd.test_postcomments.repository.PostRepository;
import com.kdkd.test_postcomments.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private PostRepository postRepository;

  @Value("${conf.jsonplaceholder.host}")
  private String host;

  @Value("${conf.protocol}")
  private String protocol; 

  @Value("${conf.jsonplaceholder.endpoints.comments}")
  private String commentsEndpoint;

  @Override
  public CommentModel[] getComments() {
    return new RestTemplate().getForObject(UriComponentsBuilder.newInstance()
            .scheme(protocol)
            .host(host)
            .path(commentsEndpoint)
            .build()
            .toString(), CommentModel[].class);
  }

  @Override
  public List<CommentEntity> saveComments() {
    CommentModel[] commentModels = this.getComments();
    List<CommentEntity> commentEntitys = new ArrayList<>(commentModels.length);
    for(CommentModel commentModel:commentModels) {
      PostEntity postEntity = this.postRepository.findById(commentModel.getPostId())
      .orElseThrow();
      commentEntitys.add(CommentEntity.builder()
        .email(commentModel.getEmail())
        .body(commentModel.getBody())
        .name(commentModel.getName())
        .postEntity(postEntity)
        .build());
    }
    return this.commentRepository.saveAll(commentEntitys);
  }
}
