package org.gfg.Spring_Minor.repository;


import org.gfg.Spring_Minor.model.Book;
import org.gfg.Spring_Minor.model.Transaction;
import org.gfg.Spring_Minor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    Transaction findByUserEmailAndBookBookNo(String email, String bookNo);

    Transaction findByUserAndBook(User user, Book book);

    //these above both ways we can use
}
