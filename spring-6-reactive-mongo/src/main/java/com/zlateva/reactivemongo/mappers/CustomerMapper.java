package com.zlateva.reactivemongo.mappers;

import com.zlateva.reactivemongo.domain.Customer;
import com.zlateva.reactivemongo.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer (CustomerDTO customerDTO);

    CustomerDTO customerToCustomerDto (Customer customer);

}
