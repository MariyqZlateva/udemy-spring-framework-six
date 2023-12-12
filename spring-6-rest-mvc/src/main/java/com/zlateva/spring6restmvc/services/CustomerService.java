package com.zlateva.spring6restmvc.services;

import com.zlateva.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
   Optional <CustomerDTO> getCustomerById(UUID uuid);

    Optional<CustomerDTO> updateCustomerByID(UUID customerId, CustomerDTO customer);

    CustomerDTO saveNewCustomer(CustomerDTO customer);

    void deleteCustomerById(UUID customerId);

    void patchCustomerById(UUID customerId, CustomerDTO customer);

}
