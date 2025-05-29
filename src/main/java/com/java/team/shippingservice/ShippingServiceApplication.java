package com.java.team.shippingservice;

import com.java.team.shippingservice.entity.User;
import com.java.team.shippingservice.repository.RoleRepository;
import com.java.team.shippingservice.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ShippingServiceApplication {

//    private final PasswordEncoder passwordEncoder;
//    private final RoleRepository roleRepository;
//    private final UserRepository userRepository;
//
//    public ShippingServiceApplication(PasswordEncoder passwordEncoder, RoleRepository roleRepository, UserRepository userRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.roleRepository = roleRepository;
//        this.userRepository = userRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ShippingServiceApplication.class, args);
    }

//    @PostConstruct
//    public void createDefaultUser() {
//        User user = new User();
//        user.setFirstName("Behruz");
//        user.setLastName("Izzatullayev");
//        user.setEmail("bexruzizzatullayev@gmail.com");
//        user.setPassword(passwordEncoder.encode("12344321"));
//        user.setCompany("Simplex ITC");
//        user.setPhoneNumber("+998936207516");
//        user.setRole(roleRepository.findByCode("ADMIN"));
//        userRepository.save(user);
//    }

}
