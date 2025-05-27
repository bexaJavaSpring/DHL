package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByCode(String code);
}
