package com.hermes.springsecurity.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(String token);
}
