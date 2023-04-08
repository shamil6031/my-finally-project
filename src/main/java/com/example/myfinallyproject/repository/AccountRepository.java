package com.example.myfinallyproject.repository;

import com.example.myfinallyproject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
