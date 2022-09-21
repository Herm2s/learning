package com.hermes.springsecurity.persistence.dao;

import com.hermes.springsecurity.persistence.model.User;
import com.hermes.springsecurity.persistence.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liu.zongbin
 * @since 2022/9/21 20:57
 */
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);

    VerificationToken findByUser(User user);
}
