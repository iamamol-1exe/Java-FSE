package in.amolD.service;

import in.amolD.model.Book;
import in.amolD.repository.BookRepository;



public class BookService {
    BookRepository repository;

    public BookService(BookRepository repository){
       this.repository=repository;
    }

    public void addBook(Book book){
        repository.addBook(book);
    }

    public Book getBook(String name){
        return repository.getBook(name);
    }
}
