package com.hermes.springsecurity.persistence.dao;

import com.hermes.springsecurity.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liu.zongbin
 * @since 2022/9/20
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Override
    void delete(User user);
}
