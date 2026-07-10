package in.amolD.repository;


import in.amolD.model.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;




@Repository
public class BookRepository {

    List<Book> books;

    BookRepository(){
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public List<Book> getBooks(){
        return books;
    }

    public Book getBook(int id){
       for(Book book:books){
           if(book.getId() == id){
               return book;
           }
       }
       return null;
    }


}
