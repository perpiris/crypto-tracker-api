package com.iperp.cryptotrackerapi.Repositories;

import com.iperp.cryptotrackerapi.Models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssetRepository extends JpaRepository<Asset, Long> {

}
