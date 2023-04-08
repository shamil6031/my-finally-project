package com.example.myfinallyproject.entity;

import com.example.myfinallyproject.dto.response.request.AccountRequestDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "our_User")
public class OurUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_surname")
    private String surname;

    @Column(name = "password")
    private String password;

    @Column(name = "pin", unique = true)
    private String pin;

    @Column(name = "role")
    private String role;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Account> accountlist;




    public void addAccountToUser(List<AccountRequestDTO> accountRequestDTOList) {
        accountlist = new ArrayList<>();
        accountRequestDTOList.forEach(accountDTO -> accountlist.add(Account.builder()
                .balance(accountDTO.getBalance())
                .currency(accountDTO.getCurrency())
                .accountNo(accountDTO.getAccountNo())
                .isActive(accountDTO.getIsActive())
                .user(this)
                .build()));
    }
}
