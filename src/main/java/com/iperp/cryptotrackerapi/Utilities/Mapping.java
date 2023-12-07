package com.iperp.cryptotrackerapi.Utilities;

import com.iperp.cryptotrackerapi.Dtos.CoinDto;
import com.iperp.cryptotrackerapi.Models.Coin;

public class Mapping {
    public static Coin mapToCoin(CoinDto coin) {

        return Coin.builder()
                .id(coin.getId())
                .name(coin.getName())
                .symbol(coin.getSymbol())
                .image_url(coin.getImage_url())
                .build();
    }

    public static CoinDto mapToCoinDto(Coin coin) {

        return CoinDto.builder()
                .id(coin.getId())
                .name(coin.getName())
                .symbol(coin.getSymbol())
                .image_url(coin.getImage_url())
                .build();
    }
}
