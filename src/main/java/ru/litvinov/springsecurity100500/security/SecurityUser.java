package ru.litvinov.springsecurity100500.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.litvinov.springsecurity100500.model.Status;
import ru.litvinov.springsecurity100500.model.User;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authority;
    private final boolean isActive;

    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> authority, boolean isActive) {
        this.username = username;
        this.password = password;
        this.authority = authority;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authority;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail()
                ,user.getPassword()
                ,user.getStatus().equals(Status.ACTIVE)
                ,user.getStatus().equals(Status.ACTIVE)
                ,user.getStatus().equals(Status.ACTIVE)
                ,user.getStatus().equals(Status.ACTIVE)
                ,user.getRole().grantedAuthoritySet());
    }
}
