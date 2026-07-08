package in.amolD;


import in.amolD.model.Book;
import in.amolD.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.metrics.ApplicationStartup;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        BookService bookService = context.getBean(BookService.class);

        Book book = new Book("Children","amolD");
        bookService.addBook(book);

        System.out.println(bookService.getBook("Children"));
    }
}