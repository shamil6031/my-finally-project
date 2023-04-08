package com.example.myfinallyproject.service;

import com.example.myfinallyproject.dto.response.CommonresponseDTO;
import com.example.myfinallyproject.dto.response.Status;
import com.example.myfinallyproject.dto.response.StatusCode;
import com.example.myfinallyproject.dto.response.UserResponseDTO;
import com.example.myfinallyproject.dto.response.exception.UserAlreadyExist;
import com.example.myfinallyproject.dto.response.request.UserrequestDTO;
import com.example.myfinallyproject.entity.OurUser;
import com.example.myfinallyproject.repository.UserRepository;
import com.example.myfinallyproject.util.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserService implements Serializable {

    @Autowired
    private DTOUtil dtoUtil;

    @Autowired
    private UserRepository userRepository;

    public CommonresponseDTO<?> saveUser(UserrequestDTO commonrequestDTO) {
        dtoUtil.isNull(commonrequestDTO);

        if (userRepository.findByPin(commonrequestDTO.getPin()).isPresent()) {
            throw new UserAlreadyExist(CommonresponseDTO.builder().status(Status.builder().statusCode(StatusCode.USER_EXIST)
                    .message("User already exist")
                    .build()).build());
        }

        OurUser user = OurUser.builder()
                .name(commonrequestDTO.getName())
                .surname(commonrequestDTO.getSurname())
                .password(commonrequestDTO.getPassword())
                .pin(commonrequestDTO.getPin())
                .role("ROLE_USER")
                .build();

        user.addAccountToUser(commonrequestDTO.getAccountRequestDTOList());


        return CommonresponseDTO.builder().status(Status.builder()
                .statusCode(StatusCode.SUCCESS)
                .message("User created").build())
                .data(UserResponseDTO.entityResponse(userRepository.save(user))).build();
    }
}
