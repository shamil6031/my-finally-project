package com.example.myfinallyproject.dto.response.exception;

import com.example.myfinallyproject.dto.response.CommonresponseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class NoSuchUserExistException extends RuntimeException {
    private CommonresponseDTO<?>responseDTO;

}
