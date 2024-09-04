package com.zlateva.reactivemongo.mappers;

import com.zlateva.reactivemongo.domain.Customer;
import com.zlateva.reactivemongo.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDTO customerToCustomerDto (Customer customer);

    Customer customerDtoToCustomer (CustomerDTO customerDTO);
}