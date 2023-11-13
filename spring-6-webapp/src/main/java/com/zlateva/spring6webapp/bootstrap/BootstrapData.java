package com.zlateva.spring6webapp.bootstrap;

import com.zlateva.spring6webapp.domain.Author;
import com.zlateva.spring6webapp.domain.Book;
import com.zlateva.spring6webapp.domain.Publisher;
import com.zlateva.spring6webapp.repositories.AuthorRepository;
import com.zlateva.spring6webapp.repositories.BookRepository;
import com.zlateva.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My publisher");
        publisher.setAddress("123 Main");

        Publisher publisherSaved = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisherSaved);
        noEJB.setPublisher(publisherSaved);

authorRepository.save(ericSaved);
authorRepository.save(rodSaved);
bookRepository.save(dddSaved);
bookRepository.save(noEJBSaved);


        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: "+ authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());

        System.out.println("Publisher count:" + publisherRepository.count() );
    }
}
