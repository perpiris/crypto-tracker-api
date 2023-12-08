package com.iperp.cryptotrackerapi.Controllers;

import com.iperp.cryptotrackerapi.Services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/coins")
public class AssetController {
    @Autowired
    AssetService assetService;
}
