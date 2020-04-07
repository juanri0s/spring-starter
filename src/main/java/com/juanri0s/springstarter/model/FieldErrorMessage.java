package com.juanri0s.springstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldErrorMessage {
    private String field;
    private String message;
}
