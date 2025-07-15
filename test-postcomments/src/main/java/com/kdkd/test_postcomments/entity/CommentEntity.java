package com.kdkd.test_postcomments.entity;

import jakarta.persistence.Column;
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

@Table(name="comments")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class CommentEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String email;
  @Column(columnDefinition = "TEXT")
  private String body;

  @ManyToOne
  @JoinColumn(name="post_id", nullable=false)
  private PostEntity postEntity;
}
