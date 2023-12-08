package com.zlateva.spring6restmvc.mappers;

import com.zlateva.spring6restmvc.entities.Beer;
import com.zlateva.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToDto (Beer beer);
}
