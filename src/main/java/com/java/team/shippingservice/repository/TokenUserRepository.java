package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.TokenUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenUserRepository extends JpaRepository<TokenUser, Long> {
    Optional<TokenUser> findByUserId(Integer userId);
}
