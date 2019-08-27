package com.example.mongodb.springbootmongodbexample.resource;

import com.example.mongodb.springbootmongodbexample.document.Users;
import com.example.mongodb.springbootmongodbexample.repository.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UsersRepository usersRepository;

    public UsersResource(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello !";
    }
}
