package com.iperp.cryptotrackerapi.Controllers;

import com.iperp.cryptotrackerapi.Dtos.CoinDto;
import com.iperp.cryptotrackerapi.Services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/coins")
public class CoinController {
    @Autowired
    private CoinService coinService;

    @GetMapping
    public ResponseEntity<List<CoinDto>> getAllCoins() {
        List<CoinDto> coins = coinService.getAllCoins();
        return new ResponseEntity<>(coins, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoinDto> getCoinById(@PathVariable long id) {
        CoinDto coin = coinService.getCoinById(id);
        if (coin != null) {
            return new ResponseEntity<>(coin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CoinDto> insertNewCoin(@RequestBody CoinDto coinDto) {
        CoinDto createdCoin = coinService.insertNewCoin(coinDto);
        return new ResponseEntity<>(createdCoin, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CoinDto> updateCoin(@RequestBody CoinDto coinDto) {
        CoinDto coin = coinService.updateCoin(coinDto);
        if (coin != null) {
            return new ResponseEntity<>(coin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoin(@PathVariable long id) {
        coinService.deleteCoin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}