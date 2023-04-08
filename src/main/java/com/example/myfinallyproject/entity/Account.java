package com.example.myfinallyproject.entity;

import com.example.myfinallyproject.util.Currency;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "currency")
    private Currency currency;
    @Column(name = "isActive")
    private boolean isActive;
    @Column(name = "accountNo")
    private int accountNo;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private OurUser user;
}
