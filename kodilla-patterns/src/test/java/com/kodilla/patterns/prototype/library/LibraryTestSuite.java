package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        Library library = new Library("Library number 1");

        Book book1 = new Book("Spring", "Mart Wit", LocalDate.of(2019, 11, 11));
        Book book2 = new Book("Something to do", "Cornelo Dan", LocalDate.of(2000, 11, 22));
        Book book3 = new Book("Short", "Phill Do", LocalDate.of(2012, 1, 1));
        Book book4 = new Book("Very", "Do Mo", LocalDate.of(1999, 4, 21));
        Book book5 = new Book("Down", "Moa Dreaw", LocalDate.of(1873, 8, 11));

        library.getBooks().addAll(Arrays.asList(book1, book2, book3, book4, book5));

        Library shallowCloneLibrary  = null;
        try {
            shallowCloneLibrary = library.shallowCopy();
            shallowCloneLibrary.setName("Library number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepCloneLibrary = null;
        try {
            deepCloneLibrary = library.deepCopy();
            deepCloneLibrary.setName("Library number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        System.out.println(library);
        System.out.println(shallowCloneLibrary);
        System.out.println(deepCloneLibrary);

        library.getBooks().remove(book1);

        assertEquals(4, library.getBooks().size());
        assertEquals(4, shallowCloneLibrary.getBooks().size());
        assertEquals(5, deepCloneLibrary.getBooks().size());
        assertEquals(library.getBooks().size(), shallowCloneLibrary.getBooks().size());
        assertNotEquals(library.getBooks().size(), deepCloneLibrary.getBooks().size());
    }
}
