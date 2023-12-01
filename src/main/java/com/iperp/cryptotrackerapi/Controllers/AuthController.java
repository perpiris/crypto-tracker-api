package com.iperp.cryptotrackerapi.Controllers;

import com.iperp.cryptotrackerapi.Dtos.UserDto;
import com.iperp.cryptotrackerapi.Dtos.RegisterDto;
import com.iperp.cryptotrackerapi.Models.AppUser;
import com.iperp.cryptotrackerapi.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody RegisterDto body) {
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public UserDto loginUser(@RequestBody RegisterDto body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }
}
