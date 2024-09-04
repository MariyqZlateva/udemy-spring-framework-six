package com.zlateva.reactivemongo.services;

import com.zlateva.reactivemongo.model.CustomerDTO;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<CustomerDTO> saveCustomer(CustomerDTO customerDTO);

    Mono<CustomerDTO> getById(String customerId);
}
