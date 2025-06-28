package org.gfg.Spring_Minor.controller;


import jakarta.validation.Valid;
import org.gfg.Spring_Minor.dto.AddUserRequest;
import org.gfg.Spring_Minor.model.User;
import org.gfg.Spring_Minor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/student")
    public ResponseEntity<User> addStudent(@RequestBody @Valid AddUserRequest addUserRequest) {
        User addedUser = userService.addStudent(addUserRequest);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    @PostMapping("/admin")
    public ResponseEntity<User> addAdmin(@RequestBody @Valid AddUserRequest addUserRequest) {
        User addedUser = userService.addAdmin(addUserRequest);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }
}
