package com.zlateva.spring6webapp.repositories;

import com.zlateva.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
