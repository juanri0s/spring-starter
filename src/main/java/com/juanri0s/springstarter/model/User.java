package com.juanri0s.springstarter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "User (JDBC)", description = "User object")
public class User {

  @NonNull
  @NotEmpty
  @Size(min = 2, message = "First name must not be less than 2 characters")
  @Column(name = "firstname", nullable = false)
  @ApiModelProperty(value = "User first name", required = true)
  private String firstName;

  @NonNull
  @NotEmpty
  @Size(min = 2, message = "Last name must not be less than 2 characters")
  @Column(name = "lastname", nullable = false)
  @ApiModelProperty(value = "User last name", required = true)
  private String lastName;
}
