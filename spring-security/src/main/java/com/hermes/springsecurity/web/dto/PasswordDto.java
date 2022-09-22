package com.hermes.springsecurity.web.dto;

import com.hermes.springsecurity.web.validation.ValidPassword;
import lombok.Data;

@Data
public class PasswordDto {

    private String oldPassword;

    private String token;

    @ValidPassword
    private String newPassword;

}
