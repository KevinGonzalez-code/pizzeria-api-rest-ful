package com.kevin.pizzeria.config;

// @Configuration
// @EnableWebSecurity
public class SecurityConfig  {

//     @Autowired
//     private DataSource dataSource;

//     @Autowired
//     private BCryptPasswordEncoder passwordEncoder;

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.jdbcAuthentication()
//                 .passwordEncoder(passwordEncoder)
//                 .dataSource(dataSource)
//                 .usersByUsernameQuery("SELECT nombre, contraseña, estado FROM usuario WHERE nombre = ?")
//                 .authoritiesByUsernameQuery(
//                         "SELECT u.nombre, r.rol FROM rol r INNER JOIN usuario u ON r.usuario_id = u.id WHERE u.nombre = ?");
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//                 .antMatchers(
//                         "/api/ingredients",
//                         "/api/pizzas",
//                         "/api/pizzas/**")
//                 .hasAnyRole("USER")
//                 .antMatchers("/api/pizzas/add")
//                 .hasAnyRole("ADMIN")
//                 .and()
//                 .formLogin()
//                 .and()
//                 .logout()
//                 .permitAll();
//     }

}
