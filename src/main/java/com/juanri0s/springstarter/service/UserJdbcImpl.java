package com.juanri0s.springstarter.service;

import com.juanri0s.springstarter.dao.UserDao;
import com.juanri0s.springstarter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserJdbcImpl implements UserJdbcService {
  @Autowired UserDao userDao;

  @Override
  public void save(User user) {
    userDao.save(user);
  }

  public ArrayList<User> findAll() {
    ArrayList<User> users = userDao.findAll();
    for (User employee : users) {
      //      System.out.println(employee.toString());
    }
    return users;
  }

  //  @Override
  //  public void findById(int userId) {
  //    User user = userDao.findById(userId);
  //    System.out.println(user);
  //  }
}
