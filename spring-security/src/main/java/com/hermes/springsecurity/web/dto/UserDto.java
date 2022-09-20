package com.hermes.springsecurity.web.dto;

import com.hermes.springsecurity.web.validation.PasswordMatches;
import com.hermes.springsecurity.web.validation.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author liu.zongbin
 * @since 2022/9/20
 */
@Data
@PasswordMatches
public class UserDto {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;
}
