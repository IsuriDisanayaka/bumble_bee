package com.icbt.bumble_bee.service;

import com.icbt.bumble_bee.dto.UserDto;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
public interface UserService {
   UserDto  saveUser(UserDto dto);
   ArrayList<UserDto> getGetAllUsers();
   List<UserDto>searchUser(String type,String input);




    
}
