package com.example.mongodb.springbootmongodbexample.config;

import com.example.mongodb.springbootmongodbexample.document.Users;
import com.example.mongodb.springbootmongodbexample.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(UsersRepository usersRepository) {
        CommandLineRunner commandLineRunner = strings -> {
            usersRepository.save(new Users(1, "Chandler", "Analytics", 300L));
            usersRepository.save(new Users(2, "Monica", "Restaurant", 200L));
        };
        return commandLineRunner;
    }
}
