package com.kdkd.test_postcomments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String body;
  private Long postid;

  @ManyToOne
  @JoinColumn(name="user_id", nullable=false)
  private UserEntity userEntity;
}
