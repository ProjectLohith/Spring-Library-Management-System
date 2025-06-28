//package org.gfg.Spring_Minor.controller;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//import org.gfg.Spring_Minor.dto.AddBookRequest;
//import org.gfg.Spring_Minor.service.BookService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.http.ResponseEntity;
//
//@ExtendWith(MockitoExtension.class)
//public class BookControllerTest {
//
//    @Mock
//    private BookService bookService;
//
//    @InjectMocks
//    private BookController bookController;
//
//    @Test
//    public void addBook_ValidBookRequest_ReturnsCreatedBook() {
//        // Arrange
//        AddBookRequest bookRequest = new AddBookRequest();
//        bookRequest.setBookNo("12345");
//        bookRequest.setTitle("Mockito Guide");
//
//        Book savedBook = new Book();
//        savedBook.setId(1);
//        savedBook.setBookNo("12345");
//        savedBook.setTitle("Mockito Guide");
//
//        when(bookService.addBook(any(AddBookRequest.class))).thenReturn(savedBook);
//
//        // Act
//        ResponseEntity<Book> response = bookController.addBook(bookRequest);
//
//        // Assert
//        Assertions.assertEquals(201, response.getStatusCodeValue());
//        Assertions.assertEquals(savedBook, response.getBody());
//    }
//}
//
