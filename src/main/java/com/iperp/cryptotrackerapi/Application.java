package com.iperp.cryptotrackerapi;

import com.iperp.cryptotrackerapi.Models.AppRole;
import com.iperp.cryptotrackerapi.Models.AppUser;
import com.iperp.cryptotrackerapi.Repositories.IRoleRepository;
import com.iperp.cryptotrackerapi.Repositories.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.HashSet;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner run(IRoleRepository roleRepository, IUserRepository userRepository, PasswordEncoder passwordEncode) {
        return args -> {
            if (roleRepository.count() == 0) {
                AppRole userRole = new AppRole();
                userRole.setAuthority("USER");
                AppRole adminRole = new AppRole();
                adminRole.setAuthority("ADMIN");

                roleRepository.save(userRole);
                roleRepository.save(adminRole);

                Set<AppRole> roles = new HashSet<>();
                roles.add(userRole);
                roles.add(adminRole);

                AppUser adminUser = new AppUser();
                adminUser.setUsername("admin");
                adminUser.setPassword(passwordEncode.encode("admin"));
                adminUser.setAuthorities(roles);

                userRepository.save(adminUser);
            }
        };
    }
}
