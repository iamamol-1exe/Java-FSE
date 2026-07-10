package in.amold.librarymanagementspringboot.controller;


import in.amold.librarymanagementspringboot.model.Book;
import in.amold.librarymanagementspringboot.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    BookService service;


    public BookController(BookService service){
        this.service = service;
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody  Book book) {
        System.out.println(book);
        service.addBook(book);
    }

    @GetMapping("/getBook/{id}")
    public Book findBookById(@PathVariable  Long id) {
            return  service.getBookById(id);
    }

    @GetMapping("/getAllBooks")
    public List<Book> findAllBooks() {
        return service.findAllBooks();
    }

    @PatchMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable  Long id, @RequestBody  Book book) {
        return service.updateBook(book);
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable  Long id) {
        service.deleteBookById(id);
    }
}
