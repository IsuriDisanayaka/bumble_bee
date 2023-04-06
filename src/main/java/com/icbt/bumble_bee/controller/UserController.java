package com.icbt.bumble_bee.controller;

import com.icbt.bumble_bee.dto.UserDto;
import com.icbt.bumble_bee.exception.NotFoundException;
import com.icbt.bumble_bee.repo.UserRepo;
import com.icbt.bumble_bee.service.UserService;
import com.icbt.bumble_bee.util.StandardResponse;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/5/2023
 **/

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDto userDto, HttpServletRequest request ) throws MessagingException, UnsupportedEncodingException {

        UserDto user = userService.saveUser(userDto,getSiteURL(request)+"/api/v1/user");

        return new ResponseEntity(new StandardResponse(200, "Done", user), HttpStatus.CREATED);
    }
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        ArrayList<UserDto> getAllUsers = userService.getGetAllUsers();

        return new ResponseEntity(new StandardResponse(200,"Done",getAllUsers),HttpStatus.OK);
    }

    @GetMapping(path = "/{type}/{input}")
    public ResponseEntity Search(@PathVariable("type")String type,@PathVariable("input") String input) {
        List<UserDto> search = userService.searchUser(type,input);
        return new ResponseEntity(new StandardResponse(200, "Done", search), HttpStatus.OK);

    }
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (userService.verify(code)) {
            System.out.println("code = " + code);
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/total")
    public int getTotalUsers() {
        return userRepo.getTotalUsers();
    }
}

