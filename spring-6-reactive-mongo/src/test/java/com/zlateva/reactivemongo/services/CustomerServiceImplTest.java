package com.zlateva.reactivemongo.services;

import com.zlateva.reactivemongo.domain.Customer;
import com.zlateva.reactivemongo.mappers.CustomerMapper;
import com.zlateva.reactivemongo.mappers.CustomerMapperImpl;
import com.zlateva.reactivemongo.model.CustomerDTO;
import com.zlateva.reactivemongo.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;



@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerRepository customerRepository;

    CustomerDTO customerDTO;

    @BeforeEach
    void setUp() {
        customerDTO = customerMapper.customerToCustomerDto(getTestCustomer());
    }



    @Test
    void finedFirstByCustomerNameTest() {
        CustomerDTO customerDto = getSavedCustomerDto();

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Mono<CustomerDTO> foundDto = customerService.getCustomerById(customerDto.getId());

        foundDto.subscribe(dto -> {
            System.out.println(dto.toString());
            atomicBoolean.set(true);
        });

        await().untilTrue(atomicBoolean);
    }

    @Test
    @DisplayName("Test Save Customer Using Subscriber")
    void saveCustomerUseSubscriber() {

        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        AtomicReference<CustomerDTO> atomicDto = new AtomicReference<>();

        Mono<CustomerDTO> savedMono = customerService.saveNewCustomer(customerDTO);

        savedMono.subscribe(savedDto -> {
            System.out.println(savedDto.getId());
            atomicBoolean.set(true);
            atomicDto.set(savedDto);
        });

        await().untilTrue(atomicBoolean);

        CustomerDTO persistedDto = atomicDto.get();
        assertThat(persistedDto).isNotNull();
        assertThat(persistedDto.getId()).isNotNull();
    }

    @Test
    @DisplayName("Test Save Customer Using Block")
    void testSaveCustomerUseBlock() {
        CustomerDTO savedDto = customerService.saveNewCustomer(getTestCustomerDto()).block();
        assertThat(savedDto).isNotNull();
        assertThat(savedDto.getId()).isNotNull();
    }

    @Test
    @DisplayName("Test Update Customer Using Block")
    void testUpdateBlocking() {
        final String newName = "New Customer Name";  // use final so cannot mutate
        CustomerDTO savedCustomerDto = getSavedCustomerDto();
        savedCustomerDto.setCustomerName(newName);

        CustomerDTO updatedDto = customerService.saveNewCustomer(Mono.just(savedCustomerDto).block()).block();

        //verify exists in db
        CustomerDTO fetchedDto = customerService.getCustomerById(updatedDto.getId()).block();
        assertThat(fetchedDto.getCustomerName()).isEqualTo(newName);
    }


    @Test
    void testDeleteCustomer() {
        CustomerDTO customerToDelete = getSavedCustomerDto();

        customerService.deleteCustomerById(customerToDelete.getId()).block();

        Mono<CustomerDTO> expectedEmptyBeerMono = customerService.getCustomerById(customerToDelete.getId());

        CustomerDTO emptyCustomer = expectedEmptyBeerMono.block();

        assertThat(emptyCustomer).isNull();

    }

    public CustomerDTO getSavedCustomerDto() {
        return customerService.saveNewCustomer(Mono.just(getTestCustomerDto()).block()).block();
    }

    public static CustomerDTO getTestCustomerDto() {
        return new CustomerMapperImpl().customerToCustomerDto(getTestCustomer());
    }

    public static Customer getTestCustomer() {
        return Customer.builder()
                .customerName("Sam Smith")
                .build();
    }

}