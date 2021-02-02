package com.stack.graphq.queries;

import com.stack.graphq.model.Author;
import com.stack.graphq.model.Book;
import com.stack.graphq.repos.AuthorRepository;
import com.stack.graphq.repos.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}