package com.kdkd.test_postcomments.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name="users")
@Builder
public class UserEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private Long userid;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
}
