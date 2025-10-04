package br.edu.infnet.agendamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    public static final String API_AGENDAMENTOS = "/api/agendamentos";
    public static final String API_MEDICOS = "/api/medicos";
    public static final String API_PACIENTES = "/api/pacientes";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
                        authorize -> authorize.requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers(HttpMethod.GET, API_AGENDAMENTOS, API_AGENDAMENTOS + "/*").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, API_AGENDAMENTOS).hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, API_AGENDAMENTOS + "/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, API_AGENDAMENTOS + "/*").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.GET, API_MEDICOS, API_MEDICOS + "/*").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, API_MEDICOS).hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, API_MEDICOS + "/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, API_MEDICOS + "/*").hasRole("ADMIN")

                                .requestMatchers(HttpMethod.GET, API_PACIENTES, API_PACIENTES + "/*").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, API_PACIENTES).hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, API_PACIENTES + "/*").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, API_PACIENTES + "/*").hasRole("ADMIN")
                                .anyRequest().authenticated())
                .httpBasic(withDefaults());

        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var admin = User.builder().username("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN").build();
        var user = User.builder().username("user").password(passwordEncoder().encode("userPass")).roles("USER").build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}