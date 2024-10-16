package com.empresa.empresa.security;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.empresa.empresa.application.service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    
    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/css/**", "/js/**", "/images/**").permitAll();
                auth.requestMatchers(HttpMethod.GET, "/", "/login").permitAll();
                auth.requestMatchers(HttpMethod.GET, "/", "/registrarcliente").hasAnyRole("ADMIN","CLIENTE");
                auth.requestMatchers(HttpMethod.POST, "/","/api/persona").hasAnyRole("ADMIN","CLIENTE");
                auth.requestMatchers(HttpMethod.GET, "/api/sucursal").hasAnyRole("ADMIN","CLIENTE","JEFERECUROSHUMANOS");
                auth.requestMatchers(HttpMethod.GET, "/", "/registrarempleado").hasAnyRole("ADMIN","JEFERECUROSHUMANOS");
                auth.requestMatchers(HttpMethod.POST, "/", "/api/persona").hasAnyRole("ADMIN","JEFERECUROSHUMANOS");

                auth.requestMatchers(HttpMethod.GET, "/index").hasAnyRole("ADMIN");
                auth.requestMatchers(HttpMethod.GET, "/home").hasAnyRole("ADMIN", "USER");
                auth.requestMatchers(HttpMethod.GET, "/users").hasAnyRole("ADMIN", "USER");
                auth.requestMatchers(HttpMethod.GET, "/gestion").hasRole("ADMIN");
                auth.requestMatchers(HttpMethod.POST, "/auth/post").hasAnyRole("ADMIN", "DEVELOPER");
                auth.anyRequest().hasAnyRole("ADMIN");
            })
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(successHandler) // Set custom success handler
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            )
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
