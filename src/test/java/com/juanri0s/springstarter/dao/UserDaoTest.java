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
//    // given
//    UserEntity user1 = new UserEntity(1, "test1", "test1");
//    UserEntity user2 = new UserEntity(2, "test2", "test2");
//    ArrayList<UserEntity> users = new ArrayList<>();
//    users.add(user1);
//    users.add(user2);
//
//    Mockito.when(userDao.findAll()).thenReturn(users);
//
//    ArrayList<UserEntity> result = userJpaController.findAll();
//
//    Assertions.assertThat(result.size()).isEqualTo(2);
//
//    Assertions.assertThat(result.get(0).getFirstName()).isEqualTo(user1.getFirstName());
//    Assertions.assertThat(result.get(1).getFirstName()).isEqualTo(user2.getFirstName());
//
//    Assertions.assertThat(result.get(0).getLastName()).isEqualTo(user1.getLastName());
//    Assertions.assertThat(result.get(1).getLastName()).isEqualTo(user2.getLastName());
//
//    Assertions.assertThat(result.get(0).getUserId()).isEqualTo(user1.getUserId());
//    Assertions.assertThat(result.get(1).getUserId()).isEqualTo(user2.getUserId());
  }
}