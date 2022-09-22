package com.hermes.springsecurity.persistence.dao;

import com.hermes.springsecurity.persistence.model.PasswordResetToken;
import com.hermes.springsecurity.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.stream.Stream;

/**
 * @author liu.zongbin
 * @since 2022/9/22 21:47
 */
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(User user);

    Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

    void deleteByExpiryDateLessThan(Date now);

    @Modifying
    @Query("delete from password_reset_token t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);
}
