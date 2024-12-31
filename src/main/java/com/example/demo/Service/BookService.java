package com.example.demo.Service;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        System.out.println("Received Book: " + book);
        // Saving the book and returning the saved entity
        return bookRepository.save(book);
    }


    public Book getBookByName(String name) {
        return bookRepository.findByTitle(name);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

}
