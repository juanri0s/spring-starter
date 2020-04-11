package com.juanri0s.springstarter.repository;

import com.juanri0s.springstarter.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
  UserEntity save(UserEntity user);

  void deleteById(Integer userId);

  ArrayList<UserEntity> findAll();

  Optional<UserEntity> findById(Integer userId);
}
