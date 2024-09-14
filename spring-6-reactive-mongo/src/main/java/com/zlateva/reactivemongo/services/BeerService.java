package com.zlateva.reactivemongo.services;

import com.zlateva.reactivemongo.model.BeerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface BeerService {


    Mono<BeerDTO> finedFirstByBeerName(String beerName);

    Flux<BeerDTO> findByBeerStyle(String beerStyle);

    Flux<BeerDTO> listBeers();

    Mono<BeerDTO> saveBeer(Mono<BeerDTO> beerDto);

    Mono<BeerDTO> saveBeer(BeerDTO beerDto);

    Mono<BeerDTO> getById(String beerId);

    Mono<BeerDTO> updateBeer(String beerId, BeerDTO beerDto);

    Mono<BeerDTO> patchBeer(String beerId, BeerDTO beerDto);

    Mono<Void> deleteBeerById(String beerId);

}
