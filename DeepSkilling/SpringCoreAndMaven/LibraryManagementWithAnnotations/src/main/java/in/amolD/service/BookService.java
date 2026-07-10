package in.amolD.service;


import in.amolD.model.Book;
import in.amolD.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    BookRepository repo;


    BookService(BookRepository repo){
        this.repo = repo;
    }


    public void addBook(Book book){
        repo.addBook(book);
        System.out.println("Book added");
    }

    public List<Book> getBooks(){
        return repo.getBooks();
    }

    public Book getBook(int id){
        return  repo.getBook(id);
    }

}
