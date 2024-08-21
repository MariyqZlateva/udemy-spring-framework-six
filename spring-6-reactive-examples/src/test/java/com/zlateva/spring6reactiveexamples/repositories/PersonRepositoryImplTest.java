package com.zlateva.spring6reactiveexamples.repositories;

import com.zlateva.spring6reactiveexamples.domain.Person;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

class PersonRepositoryImplTest {

    PersonRepository personRepository = new PersonRepositoryImpl();

    @Test
    void testMonoByIdBlock() {
        Mono<Person> personMono = personRepository.getById(1);

        Person person = personMono.block();

        System.out.println(person.toString());
    }

    @Test
    void testGetByIdSubscriber() {

        Mono<Person> personMono = personRepository.getById(1);

        personMono.subscribe(person -> {
            System.out.println(person.toString());
        });
    }

    @Test
    void testMapOperation() {

        Mono<Person> personMono = personRepository.getById(1);

        personMono.map(person -> {
            return person.getFirstName();
        }).subscribe(firstName -> {
            System.out.println(firstName);
        });
    }

    @Test
    void testFluxBlock() {
        Flux<Person> personFlux = personRepository.finedAll();

        Person person = personFlux.blockFirst();

        System.out.println(person.toString());

    }

    @Test
    void testFluxSubscriber() {
        Flux<Person> personFlux = personRepository.finedAll();

        personFlux.subscribe(person -> {
            System.out.println(person.toString());
        });
    }

    @Test
    void testFluxMap() {
        Flux<Person> personFlux = personRepository.finedAll();

        personFlux.map(person -> {
            return person.getFirstName();
        }).subscribe(firstName -> {
            System.out.println(firstName);
        });
    }

    @Test
    void testFluxToList() {
        Flux<Person> personFlux = personRepository.finedAll();

        Mono<List<Person>> listMono = personFlux.collectList();

        listMono.subscribe(list->{
            list.forEach(person -> {
                System.out.println(person.getFirstName());
            });
        });
    }

    @Test
    void testFilterOnName() {
    personRepository.finedAll()
            .filter(person -> person.getFirstName().equals("Fiona"))
            .subscribe(person -> System.out.println(person.getFirstName()));

    }

    @Test
    void testGetById() {

        Mono<Person> fionaMono = personRepository.finedAll().filter(person -> person.getFirstName().equals("Fiona"))
                .next();

        fionaMono.subscribe(person -> System.out.println(person.getFirstName()));
    }

    @Test
    void testFindPersonByIdNotFound() {

        Flux<Person> personFlux = personRepository.finedAll();

        final  Integer id = 8;

        Mono<Person> personMono = personFlux.filter(person -> person.getId().equals(id)).single()
                .doOnError(throwable -> {
                    System.out.println("Error occurred in the flux");
                    System.out.println(throwable.toString());
                });

        personMono.subscribe(person -> {
            System.out.println(person.toString());
        }, throwable -> {
            System.out.println("Error occurred in the mono");
            System.out.println(throwable.toString());
        });
    }
}