package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.TokenUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenUserRepository extends JpaRepository<TokenUser, Integer> {
}
