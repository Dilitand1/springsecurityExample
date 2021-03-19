package ru.litvinov.springsecurity100500.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    String email;
    @Column(name = "first_name")
    String first_name;
    @Column(name = "last_name")
    String last_name;
    @Column(name = "password")
    String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    Status status;
}
