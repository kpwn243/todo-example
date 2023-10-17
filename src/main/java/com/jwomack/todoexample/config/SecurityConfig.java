package com.jwomack.todoexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain authFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authz) ->
                        {
                            try {
                                authz
                                        .antMatchers("/api/v1/token").permitAll()
                                        .anyRequest().anonymous()
                                        .and()
                                        .csrf().disable()
                                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                                        .and()
                                        .requestCache().disable();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
        return http.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authz) ->
                        {
                            try {
                                authz
                                        .antMatchers(HttpMethod.GET, "/api/v1/todos").permitAll()
                                        .antMatchers("/actuator/**").permitAll()
                                        .anyRequest().anonymous()
                                        .and()
                                        .csrf().disable()
                                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                                        .and()
                                        .requestCache().disable()
                                        .addFilterAfter(new TokenFilter(), BasicAuthenticationFilter.class);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
        return http.build();
    }
}
