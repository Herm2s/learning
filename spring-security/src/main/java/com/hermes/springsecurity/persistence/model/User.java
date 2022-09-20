package com.hermes.springsecurity.persistence.model;

import lombok.Getter;
import lombok.Setter;
import org.jboss.aerogear.security.otp.api.Base32;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author liu.zongbin
 * @since 2022/9/20
 */
@Getter
@Setter
@Entity
@Table(name = "user_account")
public class User {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @Column(length = 60)
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    private boolean isUsing2FA;

    private String secret;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
        super();
        this.secret = Base32.random();
        this.enabled = false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((getEmail() == null) ? 0 : getEmail().hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User user = (User) obj;
        return getEmail().equals(user.getEmail());
    }

    @Override
    public String toString() {
        return "User [id=" +
                id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", enabled=" + enabled +
                ", isUsing2FA=" + isUsing2FA +
                ", secret=" + secret +
                ", roles=" + roles +
                "]";
    }
}
