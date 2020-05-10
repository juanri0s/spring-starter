package com.juanri0s.springstarter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "tuser")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "UserEntity (JPA)", description = "Db Entity for User")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "userid", nullable = false)
  private Integer userId;

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
