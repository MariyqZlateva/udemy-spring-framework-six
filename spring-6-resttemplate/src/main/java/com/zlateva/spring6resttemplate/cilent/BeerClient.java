package com.zlateva.spring6resttemplate.cilent;

import com.zlateva.spring6resttemplate.model.BeerDTO;
import com.zlateva.spring6resttemplate.model.BeerStyle;
import org.springframework.data.domain.Page;

public interface BeerClient {

    Page<BeerDTO> listBeers();

    Page<BeerDTO> listBeers(String beerName,
                            BeerStyle beerStyle,
                            Boolean showInventory,
                            Integer pageNumber,
                            Integer pageSize);
}
