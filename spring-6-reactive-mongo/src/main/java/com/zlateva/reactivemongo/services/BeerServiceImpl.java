package com.zlateva.reactivemongo.services;

import com.zlateva.reactivemongo.mappers.BeerMapper;
import com.zlateva.reactivemongo.model.BeerDTO;
import com.zlateva.reactivemongo.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public Mono<BeerDTO> saveBeer(Mono<BeerDTO> beerDto) {
        return beerDto.map(beerMapper::beerDtoToBeer)
                .flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDto);

    }

    @Override
    public Mono<BeerDTO> getById(String beerId) {
        return null;
    }
}
