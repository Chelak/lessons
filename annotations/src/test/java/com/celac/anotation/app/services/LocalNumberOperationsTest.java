package com.celac.anotation.app.services;

import com.celac.anotation.app.annotation.CustomAnnotation;
import com.celac.anotation.app.annotation.LocalComponent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocalNumberOperationsTest {

    private LocalNumberOperations add;
    private LocalNumberOperations div;

    @Before
    public void setUp() throws Exception {
        add =  (a,b) -> a + b;
        div = (a,b) -> a/b;
    }

    @Test
    public void testAddOperation(){
        int result = add.operation(5,6);
        System.out.println("operation result : " + result);
        assertTrue( result == 11);
    }


    @Test
    @CustomAnnotation(count = 1, books = {"dasdasd","dadsadsd"})

    public void testDivideOperation(){
        int result = div.operation(10,2);
        System.out.println("operation result : " + result);
        assertTrue( result == 5);
    }
}