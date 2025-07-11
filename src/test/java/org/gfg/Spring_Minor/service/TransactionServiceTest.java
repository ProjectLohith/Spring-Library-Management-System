package org.gfg.Spring_Minor.service;

import lombok.extern.slf4j.Slf4j;
import org.gfg.Spring_Minor.dto.TransactionRequest;
import org.gfg.Spring_Minor.enums.UserType;
import org.gfg.Spring_Minor.exceptions.TransactionException;
import org.gfg.Spring_Minor.model.Transaction;
import org.gfg.Spring_Minor.model.User;
import org.gfg.Spring_Minor.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {


    @Mock
    UserService userService;

    @Mock
    BookService bookService;

    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    TransactionService transactionService;


    @BeforeEach
    public void setup() {
        System.out.println("In before each");
        log.info("log before each");
        //transactionService=new TransactionService();
        ReflectionTestUtils.setField(transactionService, "validDays", 14);
        ReflectionTestUtils.setField(transactionService, "finePerDay", 1);

    }

    @BeforeAll
    public static void abc() {
        System.out.println("In before all");
    }

    //Test case for calculate fine function
    @Test
    public void calculateFine_WithinValidDays_ReturnsCorrectAmount() {
        //TransactionService transactionService=new TransactionService();
        Transaction transaction = Transaction.builder()
                .createdOn(new Date()).settlementAmount(-200).build();
        int amount = transactionService.calculateFine(transaction);
        Assertions.assertEquals(-200, amount);
    }

    @Test
    public void calculateFine_InvalidDays_ReturnsCorrectAmount() throws ParseException {
        //TransactionService transactionService=new TransactionService();
//        ReflectionTestUtils.setField(transactionService, "validDays", 14);
//        ReflectionTestUtils.setField(transactionService, "finePerDay", 1);
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-01");
        Transaction transaction = Transaction.builder()
                .createdOn(date).settlementAmount(-200).build();
        int amount = transactionService.calculateFine(transaction);
        Assertions.assertEquals(187, amount);
    }

    @Test
    public void fetchUser_ValidStudent_ReturnsCorrectStudent() throws TransactionException {
        User user = User.builder().id(123).userType(UserType.STUDENT).build();

        Mockito.when(userService.fetchUserByEmail("abc@gmail.com")).thenReturn(user);

        TransactionRequest request = TransactionRequest.builder().userEmail("abc@gmail.com").build();
        User returnedUser =  transactionService.fetchUser(request);

        Assertions.assertEquals(user, returnedUser);
    }

    @Test
    public void fetchUser_InvalidStudent_ThrowsException() throws TransactionException {
        User user = User.builder().id(123).userType(UserType.ADMIN).build();

        Mockito.when(userService.fetchUserByEmail("abc@gmail.com")).thenReturn(user);

        TransactionRequest request = TransactionRequest.builder().userEmail("abc@gmail.com").build();
        Assertions.assertThrows(TransactionException.class,
                () -> transactionService.fetchUser(request));
    }






}



