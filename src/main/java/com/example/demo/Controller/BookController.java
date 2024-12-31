package com.example.demo.Controller;


import com.example.demo.Entity.Book;
import com.example.demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService=bookService;
    }

    // simple api
    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        System.out.println("Received book: " + book);  // Log incoming request
        Book savedBook = bookService.addBook(book);  // Save the book to DB
        return ResponseEntity.ok(savedBook);  // Return saved book
    }

    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> getBookByName(@RequestParam String name) {
        final Book bookByName=bookService.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook=bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }
}
