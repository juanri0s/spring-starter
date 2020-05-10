package com.juanri0s.springstarter.service;

import com.juanri0s.springstarter.entity.UserEntity;
import com.juanri0s.springstarter.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
public class UserJpaService {

  @Autowired private UserRepository userRepository;

  public ArrayList<UserEntity> findAll() {
    return userRepository.findAll();
  }

  public UserEntity save(UserEntity user) {
    return userRepository.save(user);
  }

  public Optional<UserEntity> findById(Integer userId) {
    return userRepository.findById(userId);
  }

  public void deleteById(Integer userId) {
    userRepository.deleteById(userId);
  }
}
