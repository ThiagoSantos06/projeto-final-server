package com.example.projetofinal.user.rest;

import com.example.projetofinal.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void signUp(@RequestBody @Valid SignUpForm form) {
        userService.signUp(form);
    }
}
