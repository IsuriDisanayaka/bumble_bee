package com.icbt.bumble_bee.service;

import com.icbt.bumble_bee.dto.UserDto;

import java.util.ArrayList;


/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
public interface UserService {
   String saveUser(UserDto dto);
   ArrayList<UserDto> getGetAllUsers();





    
}
