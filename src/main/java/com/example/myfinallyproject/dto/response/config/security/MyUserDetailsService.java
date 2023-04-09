package com.example.myfinallyproject.dto.response.config.security;

import com.example.myfinallyproject.dto.response.CommonresponseDTO;
import com.example.myfinallyproject.dto.response.Status;
import com.example.myfinallyproject.dto.response.StatusCode;
import com.example.myfinallyproject.dto.response.exception.NoSuchUserExistException;
import com.example.myfinallyproject.entity.OurUser;
import com.example.myfinallyproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.logging.Logger;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private Logger logger;

    @Override
    public UserDetails loadUserByUsername(String pin) throws UsernameNotFoundException {
        Optional<OurUser> byPin = userRepository.findByPin(pin);
        if (byPin.isPresent()) {
            return new MyUserDetails(byPin.get());
        } else {
            logger.info("There is no user with this pin: " + pin);
            throw NoSuchUserExistException.builder()
                    .responseDTO(CommonresponseDTO.builder().status(Status.builder().statusCode(StatusCode.USER_NOT_EXSIT)
                            .message("There is no user with this pin" + pin)
                            .build()).build())
                    .build();
        }
    }
}
