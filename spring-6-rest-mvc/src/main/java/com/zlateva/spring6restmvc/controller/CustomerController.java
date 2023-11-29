package com.zlateva.spring6restmvc.controller;

import com.zlateva.spring6restmvc.model.Customer;
import com.zlateva.spring6restmvc.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
@RestController
public class CustomerController {
    public final CustomerService customerService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listAllCustomer(){
        return customerService.getAllCustomers();
    }

    @RequestMapping("{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") UUID id){
        return customerService.getCustomerById(id);
    }
}
