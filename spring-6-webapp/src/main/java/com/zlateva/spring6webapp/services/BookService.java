package com.zlateva.spring6webapp.services;

import com.zlateva.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> finedAll();
}
