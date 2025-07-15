package com.kdkd.test_postcomments.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kdkd.test_postcomments.controller.GeneralController;
import com.kdkd.test_postcomments.dto.GeneralDto;
import com.kdkd.test_postcomments.entity.CommentEntity;
import com.kdkd.test_postcomments.entity.PostEntity;
import com.kdkd.test_postcomments.entity.UserEntity;
import com.kdkd.test_postcomments.model.UserModel;
import com.kdkd.test_postcomments.repository.CommentRepository;
import com.kdkd.test_postcomments.repository.PostRepository;
import com.kdkd.test_postcomments.repository.UserRepository;
import com.kdkd.test_postcomments.service.UserService;

@RestController
public class GeneralControllerImpl implements GeneralController{
  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Override
  public List<GeneralDto> getAll() {
    UserModel[] userModels = userService.getUser();
    List<GeneralDto> generals = new ArrayList<>(userModels.length);
    for(UserModel userModel : userModels) {
      UserEntity userEntity = this.userRepository.findByUserId(userModel.getUserid());
      List<PostEntity> postEntities = this.postRepository.findAllByUserEntity(userEntity);
      List<GeneralDto.PostDto> postDtos = new ArrayList<>();
      for(PostEntity postEntity : postEntities) {
        List<CommentEntity> commentEntitys = this.commentRepository.findAllByPostEntity(postEntity);
        List<GeneralDto.PostDto.CommentDto> commentDtos = new ArrayList<>();
        for(CommentEntity commentEntity : commentEntitys) {
          commentDtos.add(GeneralDto.PostDto.CommentDto.builder()
            .name(commentEntity.getName())
            .body(commentEntity.getBody())
            .build());
        }
        postDtos.add(GeneralDto.PostDto.builder()
          .body(postEntity.getBody())
          .title(postEntity.getTitle())
          .comments(commentDtos)
          .build());
      }
      generals.add(GeneralDto.builder()
        .email(userModel.getEmail())
        .name(userModel.getName())
        .username(userModel.getUsername())
        .phone(userModel.getPhone())
        .website(userModel.getWebsite())
        .userid(userModel.getUserid())
        .posts(postDtos)
        .build());
    }
    return generals;
  }
}
