package com.icbt.bumble_bee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 4/3/2023
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminDto implements SuperDto {
    private int id;
    private String email;
    private String password;
}
