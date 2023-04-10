package uz.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private String sureName;
    private String gender;
    private String passportId;
    @Column(unique = true)
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String role;
    private Integer isActive;
}
