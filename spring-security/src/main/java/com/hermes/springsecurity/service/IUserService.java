package com.hermes.springsecurity.service;

import com.hermes.springsecurity.persistence.model.User;
import com.hermes.springsecurity.persistence.model.VerificationToken;
import com.hermes.springsecurity.web.dto.UserDto;
import com.hermes.springsecurity.web.error.UserAlreadyExistException;

/**
 * @author liu.zongbin
 * @since 2022/9/20
 */
public interface IUserService {

    User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void createVerificationToken(User user, String token);

    VerificationToken getVerificationToken(String token);

    VerificationToken generateNewVerificationToken(String existingToken);
}
