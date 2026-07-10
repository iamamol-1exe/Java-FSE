package in.amold.librarymanagementspringboot.service;

import in.amold.librarymanagementspringboot.model.Book;
import in.amold.librarymanagementspringboot.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public void addBook(Book book) {
        repo.save(book);
    }

    public Book getBookById(Long id) {
       return repo.findById(id).orElse(null);
    }

    public List<Book> findAllBooks() {
        return repo.findAll();
    }

    public Book updateBook(Book book) {
        return repo.save(book);
    }

    public void deleteBookById(Long id) {
        repo.deleteById(id);
    }

}
