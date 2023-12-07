package com.iperp.cryptotrackerapi.Dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoinDto {
    private Long id;
    private String name;
    private String symbol;
    private String image_url;
}
