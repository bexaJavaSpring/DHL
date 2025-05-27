package com.java.team.shippingservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private NameTitle title;

    @Column(unique = true)
    private String email;

    @Column(name = "verification_code")
    private String verificationCode;

    private String location;

    private String company;

    @Column(name = "has_dhl_account")
    private boolean hasDhlAccount;

    @Column(name = "can_receive_informational_email")
    private boolean canReceiveInformationalEmail;

    @Column(name = "want_to_apply_dhl_account")
    private boolean wantToApplyDhlAccount;

    @Column(name = "is_sms_enabled")
    private boolean isSmsEnabled;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
            , inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    protected Set<Role> roles;
}
