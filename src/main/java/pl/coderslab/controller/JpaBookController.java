package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import pl.coderslab.service.JpaBookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/jpa/books")
public class JpaBookController {

    private BookService jpaBookService;

    public JpaBookController(BookService jpaBookService) {
        this.jpaBookService = jpaBookService;
    }

    @GetMapping("/all")
    public String showAllBooks(Model model) {
        List<Book> books = jpaBookService.getBooks();
        model.addAttribute("books", books);
        return "all";
    }

    @GetMapping("/add")
    public String showAddBook(Model model){
        model.addAttribute("book", new Book());
        return "add";
    }

    @PostMapping("/add")
    public String addOneBook(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "add";
        }
        jpaBookService.addBook(book);
        return "all";
    }



}
