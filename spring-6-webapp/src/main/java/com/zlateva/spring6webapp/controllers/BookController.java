package com.zlateva.spring6webapp.controllers;

import com.zlateva.spring6webapp.domain.Book;
import com.zlateva.spring6webapp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        logger.info("BookController::getBooks");
        List<Book> books = new ArrayList<>();
        bookService.finedAll().forEach(books::add);
        logger.info("Books {}", books);
        model.addAttribute("books", books);
        return "books";
    }

}
