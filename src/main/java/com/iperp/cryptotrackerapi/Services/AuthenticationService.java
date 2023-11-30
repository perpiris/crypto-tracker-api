package com.iperp.cryptotrackerapi.Services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.iperp.cryptotrackerapi.Dtos.LoginDto;
import com.iperp.cryptotrackerapi.Models.AppUser;
import com.iperp.cryptotrackerapi.Models.AppRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iperp.cryptotrackerapi.Repositories.IUserRepository;
import com.iperp.cryptotrackerapi.Repositories.IRoleRepository;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public AppUser registerUser(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        AppRole userRole = roleRepository.findByAuthority("USER").get();

        Set<AppRole> authorities = new HashSet<>();
        authorities.add(userRole);

        AppUser newUser = new AppUser();
        newUser.setUsername(username);
        newUser.setPassword(encodedPassword);
        newUser.setAuthorities(authorities);

        return userRepository.save(newUser);
    }

    public LoginDto loginUser(String username, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            String token = tokenService.generateJwt(auth);

            LoginDto loggedUser = new LoginDto();
            AppUser user = userRepository.findByUsername(username).get();
            loggedUser.setUsername(user.getUsername());
            loggedUser.setToken(token);

            return loggedUser;
        } catch (AuthenticationException e) {
            return new LoginDto();
        }
    }
}
