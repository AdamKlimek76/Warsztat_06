package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.JpaBookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jpa/books")
public class JpaBookController {

    private BookService jpaBookService;

    public JpaBookController(BookService jpaBookService) {
        this.jpaBookService = jpaBookService;
    }


    //wyświetlanie wszystkich książek

    @GetMapping("/all")
    public String showAllBooks(Model model) {
        List<Book> books = jpaBookService.getBooks();
        model.addAttribute("books", books);
        return "all";
    }

    //dodawanie książki

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    @PostMapping("/add")
    public String addOneBook(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add";
        }
        jpaBookService.addBook(book);
        return "redirect: all";
    }

    //edycja książki

    @GetMapping("/edit")
    public String editBook(Model model) {
        model.addAttribute("allBooks", jpaBookService.getBooks());
        return "showBooksToEdit";
    }

    @PostMapping("/edit")
    public String showEditBookForm(@RequestParam Long bookId, Model model) {
        model.addAttribute("editBook", jpaBookService.getBookById(bookId));
        return "edit";
    }

    @PostMapping("/editbook")
    public String updateBook(@ModelAttribute("editBook")
                             @Valid Book editBook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        jpaBookService.addBook(editBook);
        return "redirect: all";
    }

    //wybierz książkę i pokaż szczegóły

    @GetMapping("/show")
    public String showBooksForm(Model model) {
        model.addAttribute("allBooks", jpaBookService.getBooks());
        return "showOneBook";
    }

    @PostMapping("/show")
    public String showBookDetails(@RequestParam Long bookId, Model model) {
        model.addAttribute("book", jpaBookService.getBookById(bookId).orElseThrow(EntityNotFoundException::new));
        return "bookDetails";
    }

    //Wybierz książke i usuń
    @GetMapping("/delete")
    public String showBooksToDelete(Model model) {
        model.addAttribute("allBooks", jpaBookService.getBooks());
        return "deleteBook";
    }

    @PostMapping("/delete")
    public String deleteBook(@RequestParam Long bookId, Model model) {
        jpaBookService.deleteBook(bookId);
        return "redirect: all";
    }

}
