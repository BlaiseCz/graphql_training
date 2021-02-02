package com.stack.graphq.repos;

import com.stack.graphq.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> { }