package com.iperp.cryptotrackerapi.Services;

import com.iperp.cryptotrackerapi.Dtos.CoinDto;
import com.iperp.cryptotrackerapi.Models.Coin;
import com.iperp.cryptotrackerapi.Repositories.ICoinRepository;
import com.iperp.cryptotrackerapi.Utilities.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.iperp.cryptotrackerapi.Utilities.Mapping.mapToCoin;
import static com.iperp.cryptotrackerapi.Utilities.Mapping.mapToCoinDto;

@Service
public class CoinService {
    @Autowired
    private ICoinRepository coinRepository;

    public List<CoinDto> getAllCoins() {
        List<Coin> coins = coinRepository.findAll();
        return coins.stream().map(Mapping::mapToCoinDto).collect(Collectors.toList());
    }

    public CoinDto getCoinById(long id) {
        Optional<Coin> coin = coinRepository.findById(id);
        return coin.map(Mapping::mapToCoinDto).orElse(null);
    }

    public CoinDto insertNewCoin(CoinDto coinDto) {
        Coin coin = coinRepository.save(mapToCoin(coinDto));
        return mapToCoinDto(coin);
    }

    public CoinDto updateCoin(CoinDto updatedCoin) {
        long id = updatedCoin.getId();
        Optional<Coin> existingCoinOptional = coinRepository.findById(id);

        if (existingCoinOptional.isPresent()) {
            Coin existingCoin = existingCoinOptional.get();
            existingCoin.setName(updatedCoin.getName());
            existingCoin.setSymbol(updatedCoin.getSymbol());
            existingCoin.setImage_url(updatedCoin.getImage_url());

            return mapToCoinDto(coinRepository.save(existingCoin));
        } else {
            return null;
        }
    }

    public void deleteCoin(long id) {
        coinRepository.deleteById(id);
    }
}
