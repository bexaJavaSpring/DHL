package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    @Query("select t from User t where t.id=?1")
    User findByIdCustom(Integer id);

    boolean existsByEmail(String email);
}
