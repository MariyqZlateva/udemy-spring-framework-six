package com.zlateva.spring6webapp.controllers;

import com.zlateva.spring6webapp.domain.Author;
import com.zlateva.spring6webapp.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {
    private final Logger logger = LoggerFactory.getLogger(AuthorController.class);
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        logger.info("AuthorController::getAuthors");
        List<Author> authors = new ArrayList<>();
        authorService.finedAll().forEach(authors::add);
        logger.info("Authors {}", authors);
        model.addAttribute("authors", authorService.finedAll());

        return "authors";
    }
}
