package com.zlateva.reactivemongo.repositories;

import com.zlateva.reactivemongo.domain.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
}
