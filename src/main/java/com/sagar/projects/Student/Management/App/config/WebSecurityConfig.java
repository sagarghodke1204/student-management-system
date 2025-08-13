package com.sagar.projects.Student.Management.App.config;

import com.sagar.projects.Student.Management.App.services.impl.CustomUserDetailsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;

@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    // This handler will check the user's role and redirect them to the correct page.
    @Bean
    public AuthenticationSuccessHandler roleBasedSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                                Authentication authentication) throws IOException, ServletException {
                // Check if the authenticated user has the 'ROLE_ADMIN' authority
                for (GrantedAuthority authority : authentication.getAuthorities()) {
                    if ("ROLE_ADMIN".equals(authority.getAuthority())) {
                        response.sendRedirect("/Home.html");
                        return; // Redirect and stop
                    }
                }
                // If not an admin, assume it's a student and redirect to their details page
                String email = authentication.getName();
                String redirectUrl = "/student-details.html?email=" + email;
                response.sendRedirect(redirectUrl);
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( auth -> auth
                        // Publicly accessible pages
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/register-student")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/*.html")).permitAll()
                        // Publicly accessible API endpoints (for registration, etc.)
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/students/post")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/admin/post")).permitAll()
                        // Protected admin-only endpoints
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/students/get")).hasRole("ADMIN")
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/students/admin/**")).hasRole("ADMIN")
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/admin/**")).hasRole("ADMIN")
                        // Protected student and admin endpoints
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/students/details")).hasAnyRole("STUDENT", "ADMIN")
                        // Any other request must be authenticated
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login.html") // The URL of your login form
                        .loginProcessingUrl("/api/login") // The endpoint that handles the form submission
                        .successHandler(roleBasedSuccessHandler()) // Use the custom handler for redirection
                        .permitAll()
                );

        return httpSecurity.build();
    }
}
