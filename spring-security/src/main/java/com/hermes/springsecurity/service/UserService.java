package com.hermes.springsecurity.service;

import com.hermes.springsecurity.persistence.dao.PasswordResetTokenRepository;
import com.hermes.springsecurity.persistence.dao.UserRepository;
import com.hermes.springsecurity.persistence.dao.VerificationTokenRepository;
import com.hermes.springsecurity.persistence.model.PasswordResetToken;
import com.hermes.springsecurity.persistence.model.User;
import com.hermes.springsecurity.persistence.model.VerificationToken;
import com.hermes.springsecurity.web.dto.UserDto;
import com.hermes.springsecurity.web.error.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

/**
 * @author liu.zongbin
 * @since 2022/9/20
 */
@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public User registerNewUserAccount(UserDto userDto) {
        if (emailExists(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + userDto.getEmail());
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        // user.setRoles(new Role(Integer.valueOf(1), user));
        return userRepository.save(user);
    }

    @Override
    public User getUser(String verificationToken) {
        return tokenRepository.findByToken(verificationToken).getUser();
    }

    @Override
    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void createVerificationToken(User user, String token) {
        final VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

    @Override
    public VerificationToken getVerificationToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public VerificationToken generateNewVerificationToken(String existingToken) {
        VerificationToken vToken = tokenRepository.findByToken(existingToken);
        vToken.updateToken(UUID.randomUUID().toString());
        return tokenRepository.save(vToken);
    }

    @Override
    public User findUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    @Override
    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);
    }

    @Override
    public Optional<User> getUserByPasswordResetToken(String token) {
        return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUser());
    }

    @Override
    public void changeUserPassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public boolean checkIfValidOldPassword(User user, String oldPassword) {
        return passwordEncoder.matches(oldPassword, user.getPassword());
    }

    private boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
