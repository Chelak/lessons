package com.celac.anotation.app.entities;

import com.celac.anotation.app.annotation.LocalComponent;

import java.util.StringJoiner;
@LocalComponent("asdasdad")
public class Book {
    private String title;

    private String description;

    public Book() {
    }

    public Book(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .toString();
    }
}
