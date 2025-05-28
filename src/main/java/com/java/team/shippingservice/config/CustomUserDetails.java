package com.java.team.shippingservice.config;

import com.java.team.shippingservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;

@Component
@AllArgsConstructor
@Setter
public class CustomUserDetails implements UserDetails {
    @Getter
    private final User user;
    private final Set<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public Integer getId() {
        return user.getId();
    }
    public String getEmail() {
        return user.getEmail();
    }
    public String getFirstName() {
        return user.getFirstName();
    }
    public String getLastName() {
        return user.getLastName();
    }
    public String getPhone() {
        return user.getPhoneNumber();
    }
    public String getCompany() {
        return user.getCompany();
    }
}
