package com.zlateva.spring6reactive.services;

import com.zlateva.spring6reactive.model.BeerDTO;
import reactor.core.publisher.Flux;

public interface BeerService {

    Flux<BeerDTO> listBeers();
}
