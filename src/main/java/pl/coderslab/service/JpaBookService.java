package pl.coderslab.service;

import pl.coderslab.repository.BookRepository;
import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(Long bookId) {
        return Optional.empty();
    }

    @Override
    public void deleteBook(Long bookId) {

    }

    @Override
    public void updateBook(Book book) {

    }
}
