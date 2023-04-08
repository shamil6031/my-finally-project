package com.example.myfinallyproject.dto.response;

import com.example.myfinallyproject.dto.response.request.AccountRequestDTO;
import com.example.myfinallyproject.entity.OurUser;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserResponseDTO implements Serializable {
    private static final long serialVersionUID = 1;
    private long id;
    private String name;
    private String surname;
    private String password;
    private String pin;
    private String role;
    private List<AccountRequestDTO> accountRequestDTOList;

    public static UserResponseDTO entityResponse(OurUser ourUser) {
        List<AccountRequestDTO> accounts = new ArrayList<>();
        ourUser.getAccountlist().forEach(accountDTO -> accounts.add(AccountRequestDTO
                .builder()
                .balance(accountDTO.getBalance())
                .AccountNo(accountDTO.getAccountNo())
                .currency(accountDTO.getCurrency())
                .isActive(accountDTO.isActive()).build()));

        return UserResponseDTO.builder().id(ourUser.getId())
                .name(ourUser.getName())
                .surname(ourUser.getSurname())
                .pin(ourUser.getPin())
                .password(ourUser.getPassword())
                .role(ourUser.getRole())
                .accountRequestDTOList(accounts).build();
    }
}
