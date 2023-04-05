package com.icbt.bumble_bee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 4/3/2023
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotBlank(message = "Email is required")
//    @Email(message = "Email is invalid")
//    @Column(unique = true, nullable = false)
//    private String email;
//
//    @NotBlank(message = "Password is required")
//    private String password;
//
//    private String verificationToken;
//
//    private boolean isVerified;
    @Column(columnDefinition = "VARCHAR(50)")
    @NotBlank(message = "Email is mandatory")
    private String email;


    @Column(columnDefinition = "VARCHAR(10)")
    private String password;
}
