package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {
    private String name;
    private Set<Book> books = new HashSet<>();
    public Library(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Library shallowCopy() throws CloneNotSupportedException{
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library library = super.clone();
        library.books = new HashSet<>();
        for(Book b : books) {
            Book book = new Book(b.getAuthor(), b.getTitle(), b.getPublicationDate());
            library.getBooks().add(book);
        }
        return library;
    }
}