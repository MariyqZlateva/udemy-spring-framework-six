package com.zlateva.reactivemongo.services;

import com.zlateva.reactivemongo.model.BeerDTO;
import reactor.core.publisher.Mono;


public interface BeerService {

    Mono<BeerDTO> saveBeer(Mono<BeerDTO> beer);

    Mono<BeerDTO> getById(String beerId);

}
