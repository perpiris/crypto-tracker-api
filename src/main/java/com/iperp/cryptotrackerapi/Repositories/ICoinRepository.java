package com.iperp.cryptotrackerapi.Repositories;

import com.iperp.cryptotrackerapi.Models.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoinRepository extends JpaRepository<Coin, Long> {

}
