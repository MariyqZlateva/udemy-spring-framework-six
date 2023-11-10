package com.zlateva.spring6webapp.repositories;

import com.zlateva.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
