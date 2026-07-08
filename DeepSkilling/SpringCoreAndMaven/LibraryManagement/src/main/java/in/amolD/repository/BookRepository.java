package in.amolD.repository;

import in.amolD.model.Book;
import in.amolD.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    List<Book> books;



    public BookRepository(){
        System.out.println("BookRepository bean Created");
        books = new ArrayList<>();
    }

    public Book getBook(String name) {
        return books.stream().filter(book -> book.getName().equals(name)).findFirst().orElse(null);
    }

    public void addBook(Book book){
        books.add(book);
    }

}
