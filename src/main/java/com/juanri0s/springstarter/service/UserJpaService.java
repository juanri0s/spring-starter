package com.juanri0s.springstarter.service;

import com.juanri0s.springstarter.entity.UserEntity;
import com.juanri0s.springstarter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserJpaService {

  @Autowired private UserRepository userRepository;

  public ArrayList<UserEntity> findAll() {
    return userRepository.findAll();
  }

  public void save(UserEntity user) {
    userRepository.save(user);
  }

  public Optional<UserEntity> findById(Integer userId) {
    return userRepository.findById(userId);
  }

  public void deleteById(Integer userId) {
    userRepository.deleteById(userId);
  }
}
