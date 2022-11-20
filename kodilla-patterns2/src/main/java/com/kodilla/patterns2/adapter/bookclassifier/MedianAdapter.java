package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        List<com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> books = bookSet.stream()
                .map(n -> new com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book(n.getAuthor(), n.getTitle(), n.getPublicationYear()))
                .collect(Collectors.toList());

        List<BookSignature> signatures = bookSet.stream()
                .map(n -> new BookSignature(n.getSignature()))
                .collect(Collectors.toList());

        Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> map = new HashMap<>();

        for (int i = 0; i < books.size(); i++) {
            map.put(signatures.get(i), books.get(i));
        }
        return medianPublicationYear(map);
    }
}
