package ee.bcs.java.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class BookController {

    @GetMapping("")
    public Book getBook() {
        Book book = new Book();
        book.setTitle("Lord of the Rings");
        return book;
    }

    @PostMapping("")
    public Book saveBook(@RequestBody Book book) {
        return book;
    }

}
