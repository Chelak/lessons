package com.celac.anotation.app.services.impl;

import com.celac.anotation.app.annotation.LocalComponent;
import com.celac.anotation.app.annotation.LogExecutionTime;
import com.celac.anotation.app.entities.Book;
import com.celac.anotation.app.services.BookService;

import java.util.Arrays;
import java.util.List;

@LocalComponent("bookService")
public class BookServiceImpl implements BookService {


    @Override
    public List<Book> getBooks() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(
                new Book("The Great Gatsby", "In my younger and more vulnerable years my father gave me some advice that I've been turning over in my mind ever since."),
                new Book("The Grapes of Wrath", "To the red country and part of the gray country of Oklahoma, the last rains came gently, and they did not cut the scarred earth."),
                new Book("Nineteen Eighty-Four", "It was a bright cold day in April, and the clocks were striking thirteen."),
                new Book("Ulysses", "Stately, plump Buck Mulligan came from the stairhead, bearing a bowl of lather on which a mirror and a razor lay crossed."),
                new Book("Lolita", "Lolita, light of my life, fire of my loins. My sin, my soul. Lo-lee-ta: the tip of the tongue taking a trip of three steps down the palette to tap, at three, on the teeth."),
                new Book("Catch-22", "It was love at first sight."),
                new Book("The Catcher in the Rye", "If you really want to hear about it, the first thing you'll probably want to know is where I was born, and what my lousy childhood was like, and how my parents were occupied and all before they"),
                new Book("Beloved", "124 was spiteful. Full of baby's venom. The women in the house knew it and so did the children.")
        );
    }
}
