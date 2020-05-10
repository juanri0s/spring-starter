package com.juanri0s.springstarter.dao;

import com.juanri0s.springstarter.controller.UserJpaController;
import com.juanri0s.springstarter.entity.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class UserDaoTest {

  @InjectMocks
  UserJpaController userJpaController;

  @Mock
  UserDao userDao;

  @Test
  void save() {}

  @Test
  void findAll() {

  }
}