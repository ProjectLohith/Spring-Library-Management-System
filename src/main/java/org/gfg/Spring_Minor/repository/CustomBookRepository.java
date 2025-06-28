package org.gfg.Spring_Minor.repository;

import org.gfg.Spring_Minor.enums.BookType;
import org.gfg.Spring_Minor.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomBookRepository {

    List<Book> findBooksByFilters(String bookTitle, BookType bookType);
}