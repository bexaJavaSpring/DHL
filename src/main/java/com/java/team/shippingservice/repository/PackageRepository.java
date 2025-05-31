package com.java.team.shippingservice.repository;

import com.java.team.shippingservice.entity.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Integer> {
}
