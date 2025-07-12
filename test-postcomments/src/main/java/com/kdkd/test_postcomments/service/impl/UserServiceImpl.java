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
import com.kdkd.test_postcomments.model.UserModel;
import com.kdkd.test_postcomments.repository.PostRepository;
import com.kdkd.test_postcomments.repository.UserRepository;
import com.kdkd.test_postcomments.service.UserService;


@Service
public class UserServiceImpl implements UserService{
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;


  @Autowired
  private UriComponentsBuilder uriComponentsBuilder;

  @Value("${conf.jsonplaceholder.endpoints.users}")
  private String userEndpoint;

  @Override
  public List<UserEntity> saveUser() {
    UserModel[] userModels = new RestTemplate()
    .getForObject(uriComponentsBuilder.path(userEndpoint).build().toString(), UserModel[].class);
    List<UserEntity> userEntitys = new ArrayList<>(userModels.length);
    for(UserModel user: userModels) {
      userEntitys.add(UserEntity.builder()
      .email(user.getEmail())
      .name(user.getName())
      .phone(user.getPhone())
      .userid(user.getUserid())
      .username(user.getUsername())
      .website(user.getWebsite())
      .build());
    }
    return userRepository.saveAll(userEntitys);
  }

  @Override
  public UserModel[] getUser() {
    return new RestTemplate().getForObject(uriComponentsBuilder.path(userEndpoint).build().toString(), UserModel[].class);
  }

  @Override
  public PostModel[] getPosts() {
    return new RestTemplate().getForObject("https://jsonplaceholder.typicode.com/posts", PostModel[].class);
  }

  @Override
  public List<PostEntity> savePosts() {
    PostModel[] postModels = this.getPosts();
    List<PostEntity> postEntities = new ArrayList<>(postModels.length);
    for(PostModel postModel: postModels) {
      postEntities.add(PostEntity.builder()
      .body(postModel.getBody())
      .title(postModel.getTitle())
      .build());
    }
    return postRepository.saveAll(postEntities);
  }
}
