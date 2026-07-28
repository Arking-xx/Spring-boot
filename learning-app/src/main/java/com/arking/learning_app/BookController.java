package com.arking.learning_app;

import com.arking.exception.BookIdMismatchException;
import com.arking.exception.BookNotFoundException;
import com.arking.persistent.model.Book;
import com.arking.persistent.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {


    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @GetMapping
    public Iterable findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle){
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(String.valueOf(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id).orElseThrow(() ->new BookNotFoundException(String.valueOf(id)));
        bookRepository.deleteById(id);
    }


    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        if (book.getId() != id){
            throw new BookIdMismatchException("Cannot find book with the corresponding id: " + id);
        }
        bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(String.valueOf(id)));
        return bookRepository.save(book);
    }







}
