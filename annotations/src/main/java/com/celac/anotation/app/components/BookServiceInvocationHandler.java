package com.celac.anotation.app.components;

import com.celac.anotation.app.annotation.LogExecutionTime;
import com.celac.anotation.app.services.BookService;
import com.celac.anotation.app.services.impl.BookServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;

public class BookServiceInvocationHandler implements InvocationHandler {

    private BookService bookService = new BookServiceImpl();

    @Override
    public Object invoke(Object object,  Method method, Object[] args) throws Throwable {
        // If the annotation is not present, just redirect the method call to its origin...
        if(!method.isAnnotationPresent(LogExecutionTime.class)) {
            return method.invoke(bookService, args);
        }

        // ... otherwise log the execution time of it.
        Instant start = Instant.now();
        Object returnObj = method.invoke(bookService, args);
        Instant end = Instant.now();
        System.out.println("Method " + method.getName() + " executed in " + Duration.between(end, start) + ".");

        return returnObj;
    }
}
