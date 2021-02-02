package com.stack.graphq.mutations;

import com.stack.graphq.error.CustomErrorHandler;
import com.stack.graphq.model.Author;
import com.stack.graphq.model.Book;
import com.stack.graphq.repos.AuthorRepository;
import com.stack.graphq.repos.BookRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new CustomErrorHandler("Could not find that author!", HttpStatus.NOT_FOUND));
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new CustomErrorHandler("Could not find that book :("));
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}
