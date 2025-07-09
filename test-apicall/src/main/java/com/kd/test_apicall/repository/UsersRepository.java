package com.kd.test_apicall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.test_apicall.entity.UserEntity;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

}
