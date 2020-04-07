package com.juanri0s.springstarter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  @NonNull
  @NotEmpty
  @Size(min = 2, message = "First name must not be less than 2 characters")
  private String firstName;

  @NonNull
  @NotEmpty
  @Size(min = 2)
  private String lastName;
}
