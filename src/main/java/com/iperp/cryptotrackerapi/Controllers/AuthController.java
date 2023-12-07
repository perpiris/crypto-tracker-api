package com.iperp.cryptotrackerapi.Controllers;

import com.iperp.cryptotrackerapi.Dtos.UserDto;
import com.iperp.cryptotrackerapi.Dtos.RegisterDto;
import com.iperp.cryptotrackerapi.Models.AppUser;
import com.iperp.cryptotrackerapi.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody RegisterDto body) {
        return authenticationService.registerUser(body.getUserName(), body.getPassword());
    }

    @PostMapping("/login")
    public UserDto loginUser(@RequestBody RegisterDto body) {
        return authenticationService.loginUser(body.getUserName(), body.getPassword());
    }
}
