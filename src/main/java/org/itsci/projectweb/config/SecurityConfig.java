package org.itsci.projectweb.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(new EncodingFilter(), ChannelProcessingFilter.class);
        http.authorizeRequests(configurer -> {
            configurer.antMatchers("/topic/**").hasRole("ADMIN")
                    .antMatchers("/afaq/**").hasRole("ADMIN")
                    .antMatchers("/qfaq/**").hasRole("ADMIN")
                    .antMatchers("/update").hasRole("ADMIN");
        });
        http.exceptionHandling(configurer -> {configurer.accessDeniedPage("/access-denied");});
        http.formLogin(configurer -> {
            try {
                configurer.loginPage("/login").loginProcessingUrl("/authenticate").permitAll().and().logout().permitAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return http.build();
    }

}