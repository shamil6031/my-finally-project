package com.example.myfinallyproject.dto.response.request;

import com.example.myfinallyproject.entity.OurUser;
import com.example.myfinallyproject.util.Currency;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class AccountRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal balance;

    private Currency currency;

    private Boolean isActive;

    private int AccountNo;

}
