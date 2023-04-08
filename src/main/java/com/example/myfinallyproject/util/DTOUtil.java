package com.example.myfinallyproject.util;

import com.example.myfinallyproject.dto.response.CommonresponseDTO;
import com.example.myfinallyproject.dto.response.Status;
import com.example.myfinallyproject.dto.response.StatusCode;
import com.example.myfinallyproject.dto.response.config.AppConfig;
import com.example.myfinallyproject.dto.response.exception.InvalidDTO;
import com.example.myfinallyproject.dto.response.request.UserrequestDTO;
import org.apache.logging.log4j.util.Timer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ObjectInputFilter;
import java.util.Objects;

@Component
public class DTOUtil {


    @Autowired
    private Logger logger;


    public void isNull(UserrequestDTO userrequestDTO) {
        logger.warn(userrequestDTO.toString());
        chechkDTO(userrequestDTO.getName());
        chechkDTO(userrequestDTO.getSurname());
        chechkDTO(userrequestDTO.getPassword());
        chechkDTO(userrequestDTO.getPin());
        chechkDTO(userrequestDTO.getAccountRequestDTOList());
    }


    private <T> void chechkDTO(T t) {
        if (Objects.isNull(t) || t.toString().isBlank()) {
            logger.error("Invalid Input");
            throw InvalidDTO.builder().responseDTO(CommonresponseDTO.builder()
                    .status(Status.builder()
                            .statusCode(StatusCode.INVALID_DTO)
                            .message("Invalid DATA")
                            .build()).build()).build();
        }

    }
}
