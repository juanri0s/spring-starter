package com.juanri0s.springstarter.repository;

import com.juanri0s.springstarter.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
  UserEntity save(UserEntity user);

  void deleteById(Integer userId);

  List<UserEntity> findAll();

//  UserEntity findByName(String firstName);
}
