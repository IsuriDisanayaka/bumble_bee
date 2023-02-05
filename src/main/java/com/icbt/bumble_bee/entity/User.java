package com.icbt.bumble_bee.entity;

import com.icbt.bumble_bee.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/2/2023
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull(message = "Name is mandatory")
    private String firstName;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull(message = "Name is mandatory")
    private String lastName;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull(message = "Address is mandatory")
    private String address;

    @Column(columnDefinition = "VARCHAR(20)")
    @NotNull(message = "Contact is mandatory")
    private String contact;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(columnDefinition = "VARCHAR(50)")
    @NotBlank(message = "NIC is mandatory")
    private String nic;

    @Column(columnDefinition = "DATETIME",nullable = false)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(columnDefinition = "DATETIME",nullable = false)
    private Date createdDate;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private boolean isDeleted;




}
