package in.amolD;


import in.amolD.config.AppConfig;
import in.amolD.model.Book;
import in.amolD.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Book book = new Book(1,"Children","AmolD");

        BookService bookService = context.getBean(BookService.class);

        bookService.addBook(book);


        System.out.println(bookService.getBook(1));

    }
}