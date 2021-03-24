package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBooks();

    void addBook(Book book);

    Optional<Book> getBookById(Long bookId);

    void deleteBook(Long bookId);

    void updateBook(Book book);

}
