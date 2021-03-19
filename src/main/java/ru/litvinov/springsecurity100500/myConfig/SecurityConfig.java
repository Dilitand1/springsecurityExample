package ru.litvinov.springsecurity100500.myConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import ru.litvinov.springsecurity100500.model.Permission;
import ru.litvinov.springsecurity100500.model.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET,"/api/**")
                //.hasAuthority(Permission.DEVELOPERS_READ.getPermission())
                .hasAnyRole(Role.USER.name(),Role.ADMIN.name())
                .antMatchers(HttpMethod.POST,"/api/**")
                //.hasAuthority(Permission.DEVELOPERS_WRITE.getPermission())
                .hasRole(Role.ADMIN.name())
                .anyRequest().authenticated().and().httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles(Role.ADMIN.name())
                        //.authorities(Role.ADMIN.grantedAuthoritySet())
                        .build(),
                User.builder()
                        .username("user")
                        .password(passwordEncoder().encode("user"))
                        .roles(Role.USER.name())
                        //.authorities(Role.USER.grantedAuthoritySet())
                        .build()
        );

    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

}
