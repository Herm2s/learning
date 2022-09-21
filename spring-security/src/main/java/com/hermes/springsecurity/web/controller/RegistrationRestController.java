package com.hermes.springsecurity.web.controller;

import com.hermes.springsecurity.persistence.model.User;
import com.hermes.springsecurity.registration.OnRegistrationCompleteEvent;
import com.hermes.springsecurity.web.dto.UserDto;
import com.hermes.springsecurity.web.error.UserAlreadyExistException;
import com.hermes.springsecurity.web.util.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author liu.zongbin
 * @since 2022/9/21 21:57
 */
@Slf4j
@RestController
public class RegistrationRestController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @PostMapping("/user/registration")
    public GenericResponse registerUserAccount(
            @Valid UserDto accountDto, HttpServletRequest request) {
        log.debug("Registering user account with information: {}", accountDto);
        User registered = createUserAccount(accountDto);
        if (registered == null) {
            throw new UserAlreadyExistException();
        }
        String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        eventPublisher.publishEvent(
                new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));

        return new GenericResponse("success");
    }
}
