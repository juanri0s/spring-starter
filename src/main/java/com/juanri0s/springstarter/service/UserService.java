package com.juanri0s.springstarter.service;

import com.juanri0s.springstarter.entity.UserEntity;
import com.juanri0s.springstarter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<UserEntity> findAll() {
    return userRepository.findAll();
  }

  public void save(UserEntity user) {
    userRepository.save(user);
  }

//  public UserEntity findByName(String username) {
//    return userRepository.findByName(username);
//  }

  public void deleteById(Integer userId) {
    userRepository.deleteById(userId);
  }
}
