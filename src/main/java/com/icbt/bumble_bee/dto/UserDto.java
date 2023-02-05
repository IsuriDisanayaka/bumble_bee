package com.icbt.bumble_bee.dto;

import com.icbt.bumble_bee.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto implements SuperDto {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String contact;
    private String email;
    private String nic;
    private Date dateOfBirth;
    private Gender gender;
    private Date createdDate;
    private boolean isDeleted;


}
