package com.juanri0s.springstarter.controller;

import com.juanri0s.springstarter.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class UserController {

  @GetMapping("/")
  public String Test() {
    return "spring-starter server working!";
  }

  @PostMapping("/user")
  public User create(@Valid @RequestBody User user) {
    log.info("requested user {}", user);
    return user;
  }

  @GetMapping("/user/{userId}")
  public User readOne() {
    return new User(null, "Crews");
  }

  @GetMapping("/user")
  public User readAll() {
    return new User("Terry", "Crews");
  }

  @PutMapping("/user/{userId}")
  public void update() {}

  @DeleteMapping("/user/{userId}")
  public void delete() {}
}
