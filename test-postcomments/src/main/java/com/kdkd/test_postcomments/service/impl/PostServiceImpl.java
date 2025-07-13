package com.kdkd.test_postcomments.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.kdkd.test_postcomments.entity.PostEntity;
import com.kdkd.test_postcomments.entity.UserEntity;
import com.kdkd.test_postcomments.model.PostModel;
import com.kdkd.test_postcomments.repository.PostRepository;
import com.kdkd.test_postcomments.repository.UserRepository;
import com.kdkd.test_postcomments.service.PostService;


@Service
public class PostServiceImpl implements PostService{

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private PostRepository postRepository;

  @Value("${conf.jsonplaceholder.host}")
  private String host;

  @Value("${conf.protocol}")
  private String protocol; 

  @Value("${conf.jsonplaceholder.endpoints.posts}")
  private String postsEndpoint;

  @Override
  public PostModel[] getPosts() {
    return new RestTemplate().getForObject(UriComponentsBuilder.newInstance()
            .scheme(protocol)
            .host(host)
            .path(postsEndpoint)
            .build()
            .toString(), PostModel[].class);
  }

  @Override
  public List<PostEntity> savePosts() {
    PostModel[] postModels = this.getPosts();
    List<PostEntity> postEntities = new ArrayList<>(postModels.length);
    for(PostModel postModel: postModels) {
      UserEntity userEntity = this.userRepository.findById(postModel.getUserid())
        .orElseThrow();
      postEntities.add(PostEntity.builder()
      .postid(postModel.getPostid())
      .body(postModel.getBody())
      .title(postModel.getTitle())
      .userEntity(userEntity)
      .build());
    }
    return postRepository.saveAll(postEntities);
  }
}
