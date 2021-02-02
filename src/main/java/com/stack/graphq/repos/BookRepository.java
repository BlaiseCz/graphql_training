package com.stack.graphq.repos;

import com.stack.graphq.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> { }