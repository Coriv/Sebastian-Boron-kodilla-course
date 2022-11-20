package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        //Given
        Book book1 = new Book("Paul Don", "Black Mirror", 1999, "G");
        Book book2 = new Book("Don Lasso", "Minotaur", 2003, "D");
        Book book3 = new Book("Min Doew", "Carrot", 2020, "C");
        Book book4 = new Book("Karl Mins", "Albert", 1954, "T");
        Book book5 = new Book("Ola Podsiadlo", "Beatrix", 1976, "DD");
        Book book6 = new Book("Simon Sor", "Whatever", 1997, "V");

        Set<Book> books = new HashSet<>();
        books.addAll(Arrays.asList(book1, book2, book3, book4, book5));

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int medianResult = medianAdapter.publicationYearMedian(books);

        //Then
        assertEquals(1998, medianResult);
    }
}