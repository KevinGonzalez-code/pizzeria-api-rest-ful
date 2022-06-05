package com.kevin.pizzeria.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT nombre, contraseña, estado FROM usuario WHERE nombre = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.nombre, r.rol FROM rol r INNER JOIN usuario u ON r.usuario_id = u.id WHERE u.nombre = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/pizzas",
                        "/pizzas/**",
                        "/ingredients")
            .hasAnyRole("ADMIN", "USER")
            .antMatchers(HttpMethod.PUT,"/pizzas/**")
            .hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.POST, "/pizzas/**")
            .hasAnyRole("ADMIN")
            .antMatchers(HttpMethod.DELETE, "/pizzas/**")
            .hasAnyRole("ADMIN")
            .and()
           
          
            .logout()
            .permitAll();
    }
}