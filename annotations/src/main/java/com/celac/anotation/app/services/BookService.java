package com.celac.anotation.app.services;

import com.celac.anotation.app.annotation.LogExecutionTime;
import com.celac.anotation.app.entities.Book;

import java.util.List;

public interface BookService {
    @LogExecutionTime
    List<Book> getBooks();
}
