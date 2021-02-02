package com.stack.graphq.resolver;

import com.stack.graphq.error.CustomErrorHandler;
import com.stack.graphq.model.Author;
import com.stack.graphq.model.Book;
import com.stack.graphq.repos.AuthorRepository;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {
    private final AuthorRepository authorRepository;

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).orElseThrow(() -> new CustomErrorHandler("Could not find that Author :(", HttpStatus.NOT_FOUND));
    }
}