package com.zlateva.spring6resttemplate.cilent;

import com.zlateva.spring6resttemplate.model.BeerDTO;
import org.springframework.data.domain.Page;

public interface BeerClient {
    Page<BeerDTO> listBeers();
}
