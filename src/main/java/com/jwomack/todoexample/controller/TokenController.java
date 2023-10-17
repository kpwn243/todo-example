package com.jwomack.todoexample.controller;

import com.jwomack.todoexample.model.Token;
import com.jwomack.todoexample.model.TokenRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TokenController {

    @PostMapping("/token")
    public Token getToken(@RequestBody TokenRequest tokenRequest) {
        return Token.builder()
                .token("abc123")
                .expiresIn(3600)
                .build();
    }
}
