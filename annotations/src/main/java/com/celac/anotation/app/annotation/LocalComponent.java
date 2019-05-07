package com.celac.anotation.app.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LocalComponent {
    String value() default "";
}
