package pl.coderslab.controller;

import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @GetMapping("")
    public List<Book> findBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{bookId}")
    public Book findBookById(@PathVariable Long bookId) {
        return this.bookService.getBookById(bookId).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        });
    }

    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable Long bookId) {
        this.bookService.deleteBook(bookId);
    }

    @PutMapping("")
    public void editBook(@RequestBody Book book) {
        this.bookService.updateBook(book);
    }


}

