package com.kd.test_apicall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class UserEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private int userId;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
}
