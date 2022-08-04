package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    @Mock
    private LibraryDatabase libraryDatabaseMock;

    @Nested
    @DisplayName("Tests of listBooksWithCondition method ")
    public class TestOfListBooksWithCondidion {
        @DisplayName("Test ListBook with condition return list")
        @Test
        void testListBooksWithConditionsReturnList() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
            Assertions.assertEquals(4, theListOfBooks.size());
        }

        @DisplayName("Test ListBook with condition more then 20")
        @Test
        void testListBooksWithConditionMoreThan20() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);

            when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);


            List<Book> theListOf0Books = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOf15Books = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOf40Books = bookLibrary.listBooksWithCondition("FortyBooks");

            assertEquals(0, theListOf0Books.size());
            assertEquals(15, theListOf15Books.size());
            assertEquals(0, theListOf40Books.size());
        }

        @DisplayName("Test ListBook with condition fragment shorter then 3")
        @Test
        void testListBooksWithConditionFragmentShorterThan3() {
            LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

            List<Book> theListOf10Books = bookLibrary.listBooksWithCondition("An");

            assertEquals(0, theListOf10Books.size());
            verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
        }

        private List<Book> generateListOfNBooks(int booksQuantity) {
            List<Book> resultList = new ArrayList<>();
            for (int n = 1; n <= booksQuantity; n++) {
                Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
                resultList.add(theBook);
            }
            return resultList;
        }
    }

    @Nested
    @DisplayName("Tests of listBooksInHandsOf method")
    public class TestsOfListBooksInHandOf {
        @DisplayName("Test without borrowed any book")
        @Test
        void caseWithoutAnyHandsOfBooks() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Marek", "Drazda", "34424344");
            List<Book> emptyList = new ArrayList<>();
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(emptyList);

            List<Book> listOfBooksHandsOf = bookLibrary.listBooksInHandsOf(libraryUser);
            Assertions.assertEquals(0, listOfBooksHandsOf.size());

        }

        @DisplayName("Test with borrowed 1  book")
        @Test
        void caseWith1handsOfBook() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Marek", "Drazda", "34424344");
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            List<Book> fullList = Arrays.asList(book1);

            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(fullList);

            List<Book> listOfBooksHandsOf = bookLibrary.listBooksInHandsOf(libraryUser);
            Assertions.assertEquals(1, listOfBooksHandsOf.size());

        }

        @DisplayName("Test with borrowed 5  books")
        @Test
        void caseWith5HandsOfBooks() {
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            LibraryUser libraryUser = new LibraryUser("Marek", "Drazda", "34424344");
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            Book book5 = new Book("Kosmiczna gra", "Stanislaw Grof", 2010);


            List<Book> fullList = Arrays.asList(book1, book2, book3, book4, book5);

            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(fullList);


            List<Book> listOfBooksHandsOf = bookLibrary.listBooksInHandsOf(libraryUser);
            Assertions.assertEquals(5, listOfBooksHandsOf.size());

        }
    }
    }