package com.zlateva.reactivemongo.services;

import com.zlateva.reactivemongo.model.BeerDTO;
import reactor.core.publisher.Mono;

public class BeerServiceImpl implements BeerService {
    @Override
    public Mono<BeerDTO> saveBeer(BeerDTO beer) {
        return null;
    }

    @Override
    public Mono<BeerDTO> getById(String beerId) {
        return null;
    }
}
