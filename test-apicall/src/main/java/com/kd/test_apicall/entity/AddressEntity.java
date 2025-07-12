package com.kd.test_apicall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Builder
@Table(name="addresses")
public class AddressEntity {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String street;
  private String suit;
  private String zipcode;
  private String city;

  @ManyToOne
  @JoinColumn(name="user_id")
  private UserEntity userEntity;
}
