package com.example.myfinallyproject.dto.response.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserrequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String surname;

    private String password;

    private String pin;

    private List<AccountRequestDTO> accountRequestDTOList;
}
