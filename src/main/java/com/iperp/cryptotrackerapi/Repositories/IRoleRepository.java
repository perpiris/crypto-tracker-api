package com.iperp.cryptotrackerapi.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iperp.cryptotrackerapi.Models.AppRole;

@Repository
public interface IRoleRepository extends JpaRepository<AppRole, Integer> {
    Optional<AppRole> findByAuthority(String authority);
}
