package com.juanri0s.springstarter.repository;

import com.juanri0s.springstarter.controller.UserJpaController;
import com.juanri0s.springstarter.entity.UserEntity;
import com.juanri0s.springstarter.service.UserJpaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

  @InjectMocks UserJpaController userJpaController;

  @Mock UserJpaService userJpaService;

  @Test
  void findAllSuccess() {
    UserEntity user1 = new UserEntity(1, "test1", "test1");
    UserEntity user2 = new UserEntity(2, "test2", "test2");
    ArrayList<UserEntity> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);

    when(userJpaService.findAll()).thenReturn(users);

    ArrayList<UserEntity> result = userJpaController.findAll();

    Assertions.assertThat(result.size()).isEqualTo(2);

    Assertions.assertThat(result.get(0).getFirstName()).isEqualTo(user1.getFirstName());
    Assertions.assertThat(result.get(1).getFirstName()).isEqualTo(user2.getFirstName());

    Assertions.assertThat(result.get(0).getLastName()).isEqualTo(user1.getLastName());
    Assertions.assertThat(result.get(1).getLastName()).isEqualTo(user2.getLastName());

    Assertions.assertThat(result.get(0).getUserId()).isEqualTo(user1.getUserId());
    Assertions.assertThat(result.get(1).getUserId()).isEqualTo(user2.getUserId());
  }

  @Test
  void findAllEmpty() {
    ArrayList<UserEntity> users = new ArrayList<>();

    when(userJpaService.findAll()).thenReturn(users);

    ArrayList<UserEntity> result = userJpaController.findAll();

    Assertions.assertThat(result.size()).isEqualTo(0);
  }

  @Test
  void save() {
    UserEntity user = new UserEntity("test1", "test1");
    UserEntity createdUser = new UserEntity(1, "test1", "test1");

    when(userJpaService.save(any(UserEntity.class))).thenReturn(createdUser);

    UserEntity result = userJpaController.save(user);

    Assertions.assertThat(result).isNotNull();

    Assertions.assertThat(result.getFirstName()).isEqualTo(user.getFirstName());
    Assertions.assertThat(result.getLastName()).isEqualTo(user.getLastName());
    Assertions.assertThat(result.getUserId()).isNotNull();
  }

  @Test
  void findById() {
    UserEntity user = new UserEntity(1, "test1", "test1");

    when(userJpaService.findById(user.getUserId())).thenReturn(Optional.of(user));

    Optional<UserEntity> result = userJpaController.findById(user.getUserId());

    Assertions.assertThat(result).isNotEmpty();
    Assertions.assertThat(result.get()).isEqualTo(user);

    Assertions.assertThat(result.get().getFirstName()).isEqualTo(user.getFirstName());
    Assertions.assertThat(result.get().getLastName()).isEqualTo(user.getLastName());
    Assertions.assertThat(result.get().getUserId()).isEqualTo(user.getUserId());
  }
}
