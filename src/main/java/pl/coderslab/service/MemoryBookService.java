package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryBookService implements BookService {

    private List<Book> list;
    private static Long nextId = 4L;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }


    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MemoryBookService.nextId = nextId;
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId);
        list.add(book);
        nextId++;
    }

    @Override
    public Optional<Book> getBookById(Long bookId) {
        return list.stream()
                .filter(book -> bookId.equals(book.getId()))
                .findFirst();
    }

    @Override
    public void deleteBook(Long bookId) {
        List<Book>listAfterDeleting=list.stream()
                .filter(book -> !bookId.equals(book.getId()))
                .collect(Collectors.toList());
        list=listAfterDeleting;
    }

    @Override
    public void updateBook(Book bookToUpdate) {
        List<Book> updatedList = list.stream()
                .map(book -> {
                    if (book.getId().equals(bookToUpdate.getId())) {
                    book.setAuthor(bookToUpdate.getAuthor());
                    book.setIsbn(bookToUpdate.getIsbn());
                    book.setPublisher(bookToUpdate.getPublisher());
                    book.setType(bookToUpdate.getType());
                    book.setTitle(bookToUpdate.getTitle());
                    }
                    return book;
                })
                .collect(Collectors.toList());
        list = updatedList;
    }
}
