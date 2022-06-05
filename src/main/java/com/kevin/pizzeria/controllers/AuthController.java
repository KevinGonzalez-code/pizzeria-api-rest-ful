package com.kevin.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.pizzeria.config.AuthenticationRequest;
import com.kevin.pizzeria.config.AuthenticationResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // @Autowired
    // private AuthenticationManager authenticationManager;

    
    // @GetMapping("/authenticate")
    // public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request){

    //    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getContraseña());


    // }

}
