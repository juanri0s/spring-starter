package com.juanri0s.springstarter.controller;

import com.juanri0s.springstarter.model.FieldErrorMessage;
import com.juanri0s.springstarter.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class UserController {

  @GetMapping("/")
  public String Test() {
    return "spring-starter server working!";
  }

  @PostMapping("/user")
  public User create(@Valid @RequestBody User user) {
    log.info("Req {}", user);
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

  @GetMapping("/user/{userId}")
  public User readOne() {
    return new User(null, null);
  }

  @GetMapping("/user")
  public User readAll() {
    return new User(null, null);
  }

  @PutMapping("/user/{userId}")
  public void update() {}

  @DeleteMapping("/user/{userId}")
  public void delete() {}
}
