package com.iperp.cryptotrackerapi.Dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String username;
    private List<String> roles;
    private String token;
}
