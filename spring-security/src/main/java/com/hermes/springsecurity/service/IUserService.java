package com.hermes.springsecurity.service;

import com.hermes.springsecurity.persistence.model.User;
import com.hermes.springsecurity.web.dto.UserDto;

/**
 * @author liu.zongbin
 * @since 2022/9/20
 */
public interface IUserService {

    User registerNewUserAccount(UserDto userDto);
}
