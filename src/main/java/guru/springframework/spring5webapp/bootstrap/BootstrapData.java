package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepo;
    private final BookRepository bookRepo;
    private final PublisherRepository publisherRepo;


    @Override
    public void run(String... args) throws Exception {
        Publisher penguin=new Publisher("Penguin","London");

        Author eric =new Author("Eri","Evans");
        Book ddd = new Book("Domain Drive De3sign","12543");
        penguin.getBooks().add(ddd);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepo.save(eric);
        bookRepo.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development with No EJB","184647653");
        rod.getBooks().add(noEJB);
        penguin.getBooks().add(noEJB);

        noEJB.getAuthors().add(rod);
        authorRepo.save(rod);
        bookRepo.save(noEJB);
        publisherRepo.save(penguin);

        System.out.println("Started the app in bootstrap");
        System.out.println(" Number of books is " + bookRepo.count());
        System.out.println(" Number of authors is " + authorRepo.count());
        System.out.println(" Number of publishers is " + publisherRepo.count());

    }

public BootstrapData(AuthorRepository authorRepo, BookRepository bookRepo,PublisherRepository publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this .publisherRepo=publisherRepo;
    }
}
