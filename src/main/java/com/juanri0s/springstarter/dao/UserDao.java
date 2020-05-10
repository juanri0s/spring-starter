package com.juanri0s.springstarter.dao;

import com.juanri0s.springstarter.entity.UserEntity;
import com.juanri0s.springstarter.model.User;

import java.util.ArrayList;

public interface UserDao {
  void save(User user);

  ArrayList<User> findAll();
}
