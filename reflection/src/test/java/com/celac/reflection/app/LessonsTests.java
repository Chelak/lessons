package com.celac.reflection.app;

import com.celac.reflection.app.entities.Department;
import com.celac.reflection.app.entities.Employee;
import com.celac.reflection.app.tools.LocalObjectInfoLogger;
import com.celac.reflection.app.tools.PackageReaderUtil;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class LessonsTests {


    @Test
    public void readClassFields() throws ClassNotFoundException {
        final Class<?> clazz = Class.forName("com.celac.reflection.app.entities.Employee");
        printClassInfo(clazz);
    }

    @Test
    public void showAllClassesFromPackage() throws IOException, ClassNotFoundException {
        final Class[] classes = PackageReaderUtil.getClassesFromPackage("com.celac.reflection.app");
        for (Class clazz : classes) {
            printClassInfo(clazz);
        }
    }

    @Test
    public void testLocalLogger() throws IllegalAccessException {
        Department department = new Department();
        department.setTitle("Department 1");
        department.setDescription("Department description 1");
        Employee employee = new Employee();
        employee.setDepartment(department);

        employee.setFirstName("FistName");
        employee.setLastName("asdasdasd");

        LocalObjectInfoLogger.printInfo(department);
        LocalObjectInfoLogger.printInfo(employee);

    }


    private void printClassInfo(Class<?> clazz) {
        final String className = clazz.getSimpleName();
        final Field[] fields = clazz.getDeclaredFields();
        System.out.println("Class: " + className);

        for (Field field : fields) {
            System.out.println("** fieldName: " + field.getName());
        }

        Constructor<?>[]  constructors = clazz.getConstructors();

        for (Constructor constructor : constructors ) {
            System.out.println("Constructor with parameters types:  ");
            System.out.println(constructor.getParameterTypes().getClass());
        }
    }
}
