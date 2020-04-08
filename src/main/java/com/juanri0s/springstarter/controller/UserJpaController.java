package com.juanri0s.springstarter.controller;

import com.juanri0s.springstarter.entity.UserEntity;
import com.juanri0s.springstarter.model.FieldErrorMessage;
import com.juanri0s.springstarter.service.UserJpaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/jpa")
public class UserJpaController {

  @Autowired private UserJpaService userService;

  @GetMapping("/user/{userId}")
  public Optional<UserEntity> readOne(@PathVariable @NotEmpty Integer userId) {
    return userService.findById(userId);
  }

  @GetMapping("/user")
  public List<UserEntity> readAll() {
    return userService.findAll();
  }

  @PostMapping("/user")
  public UserEntity create(@Valid @RequestBody UserEntity user) {
    userService.save(user);
    return user;
  }

  @DeleteMapping("/user/{userId}")
  public void delete(@PathVariable @NotEmpty Integer userId) {
    userService.deleteById(userId);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<FieldErrorMessage> handleValidationExceptions(MethodArgumentNotValidException e) {
    List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
    return fieldErrors.stream()
        .map(
            fieldError ->
                new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
        .collect(Collectors.toList());
  }
}
