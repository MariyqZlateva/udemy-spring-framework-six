package com.zlateva.spring6reactive.mappers;

import com.zlateva.spring6reactive.domain.Customer;
import com.zlateva.spring6reactive.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDTO dto);
    CustomerDTO customerToCustomerDto(Customer customer);
}
