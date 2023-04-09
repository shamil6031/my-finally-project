package com.example.myfinallyproject.dto.response.exception;

import com.example.myfinallyproject.dto.response.CommonresponseDTO;
import com.example.myfinallyproject.dto.response.Status;
import com.example.myfinallyproject.dto.response.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException  {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?>internalError(){
    return new ResponseEntity<>(CommonresponseDTO.builder().status(Status.builder()
            .statusCode(StatusCode.INTERNAL_ERROR)
            .message("Internal Error").build()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = InvalidDTO.class)
    public ResponseEntity<?>invalidDTO(InvalidDTO invalidDTO){
        return new ResponseEntity<>(invalidDTO.getResponseDTO(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserAlreadyExist.class)
    public  ResponseEntity<?>userExsist(UserAlreadyExist userAlreadyExist){
        return new ResponseEntity<>(userAlreadyExist.getResponseDTO(),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = NoSuchUserExistException.class)
    public ResponseEntity<?>notFoundUser(NoSuchUserExistException noSuchUserExistException){
        return new ResponseEntity<>(noSuchUserExistException.getResponseDTO(), HttpStatus.NOT_FOUND);
    }

}
