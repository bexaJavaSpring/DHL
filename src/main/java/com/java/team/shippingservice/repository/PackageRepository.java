package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PackageRepository extends JpaRepository<Packages, Integer> {
    @Query("select t from Packages t where t.id=?1")
    Packages findByIdCustom(Integer id);
}
