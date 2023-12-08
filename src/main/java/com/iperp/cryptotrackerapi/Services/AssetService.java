package com.iperp.cryptotrackerapi.Services;

import com.iperp.cryptotrackerapi.Repositories.IAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    @Autowired
    IAssetRepository assetRepository;
}
