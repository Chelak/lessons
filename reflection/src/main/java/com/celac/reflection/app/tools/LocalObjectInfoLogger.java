package com.celac.reflection.app.tools;

import java.lang.reflect.Field;

public class LocalObjectInfoLogger {

    public static void printInfo(Object obj) throws IllegalAccessException {
        final  Class<?> clazz  = obj.getClass();
        final Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            if (!field.isAccessible()){
                field.setAccessible(true);
                System.out.println(field.getName() + " : " + field.get(obj) );
                field.setAccessible(false);
            } else {
                System.out.println(field.getName() + " : " + field.get(obj) );
            }

        }
    }
}
