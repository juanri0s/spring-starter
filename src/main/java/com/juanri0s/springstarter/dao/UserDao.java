package com.juanri0s.springstarter.dao;

import com.juanri0s.springstarter.model.User;

import java.util.List;

public interface UserDao {
  void save(User user);

  List<User> findAll();
}
