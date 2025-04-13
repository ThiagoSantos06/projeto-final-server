package com.example.projetofinal.authentication.rest;

import com.example.projetofinal.authentication.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void signIn(@RequestBody @Valid SignInForm form) {
        authenticationService.signIn(form);
    }
}
