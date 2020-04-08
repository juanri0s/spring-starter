package com.juanri0s.springstarter.controller;

import com.juanri0s.springstarter.model.FieldErrorMessage;
import com.juanri0s.springstarter.model.User;
import com.juanri0s.springstarter.service.UserJdbcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("api/jdbc")
public class UserJdbcController {
  @Autowired private UserJdbcService userService;

  @GetMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> readAll() {
    return userService.findAll();
  }

  @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
  public User create(@Valid @RequestBody User user) {
    userService.save(user);
    return user;
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
