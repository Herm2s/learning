package com.hermes.springsecurity1.support;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.io.Serial;
import java.util.Collection;

/**
 * 短信验证Token
 *
 * @author liu.zongbin
 * @since 2023/1/23
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {

    @Serial
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final Object principal;

    private Object credentials;

    public SmsCodeAuthenticationToken(Object principal, Object credentials) {
        super(null);
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false);
    }

    public SmsCodeAuthenticationToken(Object principal, Object credentials,
                                      Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }


    public static SmsCodeAuthenticationToken unauthenticated(Object principal, Object credentials) {
        return new SmsCodeAuthenticationToken(principal, credentials);
    }

    public static SmsCodeAuthenticationToken authenticated(Object principal, Object credentials) {
        return new SmsCodeAuthenticationToken(principal, credentials, null);
    }
    public static SmsCodeAuthenticationToken authenticated(Object principal, Object credentials,
                                                           Collection<? extends GrantedAuthority> authorities) {
        return new SmsCodeAuthenticationToken(principal, credentials, authorities);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }
}
