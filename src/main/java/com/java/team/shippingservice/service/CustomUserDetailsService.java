package com.java.team.shippingservice.service;

import com.java.team.shippingservice.config.CustomUserDetails;
import com.java.team.shippingservice.entity.User;
import com.java.team.shippingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null)
            throw new RuntimeException("User not found");
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (Objects.nonNull(user.getRole()))
                authorities.add(authority.apply(user.getRole().getAuthority()));
        return new CustomUserDetails(user, authorities);
    }

    private final static Function<String, SimpleGrantedAuthority> authority = SimpleGrantedAuthority::new;
}
