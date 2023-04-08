package com.example.myfinallyproject.dto.response.exception;

import com.example.myfinallyproject.dto.response.CommonresponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserAlreadyExist extends RuntimeException {
private final CommonresponseDTO<?> responseDTO;
}
