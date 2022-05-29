package com.kevin.pizzeria.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    private String usuario;
    private String contraseña;
}
