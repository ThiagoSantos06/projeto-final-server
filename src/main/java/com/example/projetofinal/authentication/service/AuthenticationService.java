package com.example.projetofinal.authentication.service;

import com.example.projetofinal.authentication.rest.SignInForm;
import com.example.projetofinal.exception.APIException;
import com.example.projetofinal.user.domain.User;
import com.example.projetofinal.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signIn(SignInForm form) {
        User user = userRepository.findByUsername(form.username());
        if (user == null) {
            throw new APIException("User not found", HttpStatus.NOT_FOUND);
        }

        if (!user.getPassword().equals(form.password())) {
            throw new APIException("Username or password is incorrect", HttpStatus.UNAUTHORIZED);
        }
    }

}