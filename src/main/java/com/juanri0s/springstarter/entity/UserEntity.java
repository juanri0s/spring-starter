package com.juanri0s.springstarter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "tuser")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonIgnore
  @Column(name = "userid", nullable = false)
  private Integer userId;

  @NonNull
  @NotEmpty
  @Size(min = 2, message = "First name must not be less than 2 characters")
  @Column(name = "firstname", nullable = false)
  private String firstName;

  @NonNull
  @NotEmpty
  @Size(min = 2, message = "Last name must not be less than 2 characters")
  @Column(name = "lastname", nullable = false)
  private String lastName;
}
