package com.todo.demo.Config;

import com.todo.demo.Note.Note;
import com.todo.demo.Note.Priority;
import com.todo.demo.Repository.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = NoteRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(NoteRepository noteRepository) {
        CommandLineRunner commandLineRunner = strings -> {
            noteRepository.save(new Note(1, "Work", "Complete work tasks", Priority.medium));
            noteRepository.save(new Note(2, "Home", "Complete home tasks", Priority.high));
        };
        return commandLineRunner;
    }
}

