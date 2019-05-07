package com.celac.anotation.app;

import com.celac.anotation.app.components.BookServiceInvocationHandler;
import com.celac.anotation.app.entities.Book;
import com.celac.anotation.app.services.BookService;

import java.lang.reflect.Proxy;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        System.out.println("Start");
        BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}, new BookServiceInvocationHandler());

        List<Book> books = bookService.getBooks();
        for (Book b: books) {
            System.out.println(b.toString());
        }
        System.out.println("Finish");
    }
}
