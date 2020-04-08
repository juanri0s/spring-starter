package com.juanri0s.springstarter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(value = "FieldErrorMessage", description = "Error object for BAD_REQUEST on a field")
public class FieldErrorMessage {
  @ApiModelProperty(value = "Validation error field")
  private String field;

  @ApiModelProperty(value = "Validation error message")
  private String message;
}
