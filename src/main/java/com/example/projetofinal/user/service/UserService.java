package com.example.projetofinal.user.service;

import com.example.projetofinal.user.domain.User;
import com.example.projetofinal.user.repository.UserRepository;
import com.example.projetofinal.user.rest.SignUpForm;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(SignUpForm form) {
        User user = new User(form);
        userRepository.save(user);
    }

}
