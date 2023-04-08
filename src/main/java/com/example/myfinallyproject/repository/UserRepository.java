package com.example.myfinallyproject.repository;

import com.example.myfinallyproject.entity.OurUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<OurUser, Long> {
    @Query(value = "select  p FROM OurUser p join fetch p.accountlist where p.pin =:pin")
    Optional<OurUser>findByPin(String pin);
}
