package com.example.mongodb.springbootmongodbexample.repository;

import com.example.mongodb.springbootmongodbexample.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, Integer> {
}
