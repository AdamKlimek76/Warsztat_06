package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.model.Book;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {





}