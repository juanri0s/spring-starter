package com.juanri0s.springstarter.service;

import com.juanri0s.springstarter.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface UserJdbcService {
  void save(User user);

  ArrayList<User> findAll();
}
