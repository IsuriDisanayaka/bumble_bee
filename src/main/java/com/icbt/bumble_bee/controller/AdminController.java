package com.icbt.bumble_bee.controller;

import com.icbt.bumble_bee.service.AdminService;
import com.icbt.bumble_bee.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 4/3/2023
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/{email}/{password}")
    public ResponseEntity searchAdmin(@PathVariable String email, @PathVariable String password) {
        Boolean isAuth = adminService.searchUser(email, password);
        return new ResponseEntity(new StandardResponse(200, "Done",isAuth.toString() ), HttpStatus.OK);
    }
}
