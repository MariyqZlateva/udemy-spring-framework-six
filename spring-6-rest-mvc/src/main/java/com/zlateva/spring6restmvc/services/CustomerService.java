package com.zlateva.spring6restmvc.services;

import com.zlateva.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(UUID uuid);


}
