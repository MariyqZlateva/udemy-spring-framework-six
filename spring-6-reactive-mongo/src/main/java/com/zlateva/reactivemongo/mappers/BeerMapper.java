package com.zlateva.reactivemongo.mappers;

import com.zlateva.reactivemongo.domain.Beer;
import com.zlateva.reactivemongo.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDTO beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDTO beerDTO);
}
