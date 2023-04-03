package com.icbt.bumble_bee.controller;

import com.icbt.bumble_bee.dto.UserDto;
import com.icbt.bumble_bee.exception.NotFoundException;
import com.icbt.bumble_bee.service.UserService;
import com.icbt.bumble_bee.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity saveUser(@RequestBody UserDto userDto) {
        UserDto user = userService.saveUser(userDto);

        return new ResponseEntity(new StandardResponse(200, "Done", user), HttpStatus.CREATED);
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
}

