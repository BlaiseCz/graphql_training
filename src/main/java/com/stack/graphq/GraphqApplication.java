package com.stack.graphq;

import com.stack.graphq.model.Author;
import com.stack.graphq.model.Book;
import com.stack.graphq.mutations.Mutation;
import com.stack.graphq.queries.Query;
import com.stack.graphq.repos.AuthorRepository;
import com.stack.graphq.repos.BookRepository;
import com.stack.graphq.resolver.BookResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqApplication.class, args);
    }

}
