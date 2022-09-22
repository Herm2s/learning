package com.hermes.springsecurity.web.controller;

import com.hermes.springsecurity.persistence.model.User;
import com.hermes.springsecurity.registration.OnRegistrationCompleteEvent;
import com.hermes.springsecurity.security.ISecurityUserService;
import com.hermes.springsecurity.service.IUserService;
import com.hermes.springsecurity.web.dto.PasswordDto;
import com.hermes.springsecurity.web.dto.UserDto;
import com.hermes.springsecurity.web.error.InvalidOldPasswordException;
import com.hermes.springsecurity.web.error.UserAlreadyExistException;
import com.hermes.springsecurity.web.error.UserNotFoundException;
import com.hermes.springsecurity.web.util.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

/**
 * @author liu.zongbin
 * @since 2022/9/21 21:57
 */
@Slf4j
@RestController
public class RegistrationRestController {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private IUserService userService;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private MessageSource messages;

    @Autowired
    private ISecurityUserService securityUserService;

    @Autowired
    private Environment env;

    @PostMapping("/user/registration")
    public GenericResponse registerUserAccount(@Valid UserDto accountDto, HttpServletRequest request) {
        log.debug("Registering user account with information: {}", accountDto);
        User registered = createUserAccount(accountDto);
        if (registered == null) {
            throw new UserAlreadyExistException();
        }
        String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        eventPublisher.publishEvent(
                new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));

        return new GenericResponse("success");
    }

    private User createUserAccount(UserDto accountDto) {
        return new User();
    }

    @PostMapping("/user/resetPassword")
    public GenericResponse resetPassword(HttpServletRequest request,
                                         @RequestParam("email") String userEmail) {
        User user = userService.findUserByEmail(userEmail);
        if (user == null) {
            throw new UserNotFoundException();
        }
        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);
        mailSender.send(constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, user));
        return new GenericResponse(
                messages.getMessage("message.resetPasswordEmail", null,
                        request.getLocale()));
    }

    @GetMapping("/user/changePassword")
    public String showChangePasswordPage(Locale locale, Model model, @RequestParam("token") String token) {
        String result = securityUserService.validatePasswordResetToken(token);
        if (result != null) {
            String message = messages.getMessage("auth.message." + result, null, locale);
            return "redirect:/login.html?lang="
                    + locale.getLanguage() + "&message=" + message;
        } else {
            model.addAttribute("token", token);
            return "redirect:/updatePassword.html?lang=" + locale.getLanguage();
        }
    }

    @PostMapping("/user/savePassword")
    public GenericResponse savePassword(final Locale locale, @Valid PasswordDto passwordDto) {

        String result = securityUserService.validatePasswordResetToken(passwordDto.getToken());

        if (result != null) {
            return new GenericResponse(messages.getMessage(
                    "auth.message." + result, null, locale));
        }

        Optional<User> user = userService.getUserByPasswordResetToken(passwordDto.getToken());
        if (user.isPresent()) {
            userService.changeUserPassword(user.get(), passwordDto.getNewPassword());
            return new GenericResponse(messages.getMessage(
                    "message.resetPasswordSuc", null, locale));
        } else {
            return new GenericResponse(messages.getMessage(
                    "auth.message.invalid", null, locale));
        }
    }

    @PostMapping("/user/updatePassword")
    @PreAuthorize("hasRole('READ_PRIVILEGE')")
    public GenericResponse changeUserPassword(Locale locale,
                                              @RequestParam("password") String password,
                                              @RequestParam("oldpassword") String oldPassword) {
        User user = userService.findUserByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName());

        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
            throw new InvalidOldPasswordException();
        }
        userService.changeUserPassword(user, password);
        return new GenericResponse(messages.getMessage("message.updatePasswordSuc", null, locale));
    }

    private SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, User user) {
        String url = contextPath + "/user/changePassword?token=" + token;
        String message = messages.getMessage("message.resetPassword", null, locale);
        return constructEmail("Reset Password", message + " \r\n" + url, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body, User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom(env.getProperty("support.email"));
        return email;
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
