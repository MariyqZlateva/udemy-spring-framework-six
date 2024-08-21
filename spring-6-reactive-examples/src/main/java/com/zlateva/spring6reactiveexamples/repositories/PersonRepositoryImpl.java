package com.zlateva.spring6reactiveexamples.repositories;

import com.zlateva.spring6reactiveexamples.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PersonRepositoryImpl implements PersonRepository {

    Person michel = Person.builder().id(1).firstName("Michel").lastName("Weston").build();
    Person fiona = Person.builder().id(2).firstName("Fiona").lastName("Glenanne").build();
    Person sam = Person.builder().id(3).firstName("Sam").lastName("Axe").build();
    Person jesse = Person.builder().id(4).firstName("Jesse").lastName("Porter").build();

    @Override
    public Mono<Person> getById(Integer id) {
        return finedAll().filter(person ->
            person.getId().equals(id)).next();
    }

    @Override
    public Flux<Person> finedAll() {
        return Flux.just(michel, fiona, sam, jesse);
    }
}
