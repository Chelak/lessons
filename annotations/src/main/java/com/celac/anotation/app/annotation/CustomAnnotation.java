package com.celac.anotation.app.annotation;


import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    int      count();
    String[] books();
}
