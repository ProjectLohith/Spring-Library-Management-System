package org.gfg.Spring_Minor.repository;

// by default spring uses this way of file name for implementation of CustomBookRepository Interface methods
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.gfg.Spring_Minor.enums.BookType;
import org.gfg.Spring_Minor.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomBookRepositoryImpl implements CustomBookRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Book> findBooksByFilters(String bookTitle, BookType bookType) {
        // this is to write criteria queries i.e queries which handles the filters form user
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        //this is basically select statement
        Root<Book> bookRoot = criteriaQuery.from(Book.class);

        //This is for storing all filters
        List<Predicate> predicates = new ArrayList<>();

        if (bookTitle != null && !bookTitle.isEmpty()) {
            Predicate titlePredicate = criteriaBuilder.like(bookRoot.get("bookTitle"),
                    "%" + bookTitle + "%");
            predicates.add(titlePredicate);
        }

        if (bookType != null) {
            Predicate typePredicate = criteriaBuilder.equal(bookRoot.get("bookType"),
                    bookType);
            predicates.add(typePredicate);
        }

        //here we are merging the filter with 'OR'
        Predicate finalPredicate = criteriaBuilder.or(predicates.toArray(new Predicate[0]));

//        Predicate amount = criteriaBuilder.equal(bookRoot.get("securityAmount"),
//                100);
//
//        Predicate final2 = criteriaBuilder.and(finalPredicate, amount);

//        criteriaQuery.select(bookRoot).where(predicates.toArray(new Predicate[0]));

        criteriaQuery.select(bookRoot).where(finalPredicate);

        return entityManager.createQuery(criteriaQuery).getResultList();

    }

//    @Override
//    public List<Book> findBooksByFilters(String bookTitle, BookType bookType) {
//        return null;
//    }
}
