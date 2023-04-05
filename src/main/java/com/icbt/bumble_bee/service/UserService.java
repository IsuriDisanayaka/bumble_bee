package com.icbt.bumble_bee.service;

import com.icbt.bumble_bee.dto.UserDto;
import com.icbt.bumble_bee.entity.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
public interface UserService {
   UserDto  saveUser(UserDto dto ,String siteURL) throws MessagingException, UnsupportedEncodingException;
   ArrayList<UserDto> getGetAllUsers();
   List<UserDto>searchUser(String type,String input);
   public void sendVerificationEmail(User user, String siteURL) throws UnsupportedEncodingException, MessagingException;
   public boolean verify(String verificationCode);


    
}
