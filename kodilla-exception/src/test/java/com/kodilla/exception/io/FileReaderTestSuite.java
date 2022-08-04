package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testReadFile () {
        FileReader fileReader = new FileReader();

        assertDoesNotThrow(() -> fileReader.readFile());

    }

    @Test
    void whenFileDoesNotExistFileReaderShoudThrowExcepion() {
    FileReader fileReader = new FileReader();
    String fileName = "Nie-ma-takieg-pliku.txt";

    assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
    }

    @Test
    void testFileWithName() {
        FileReader fileReader = new FileReader();

        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("Tekst.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow( () -> fileReader.readFile("names.txt"))
                );
    }

    @Test
    void testProbablyWillThrowExceptionMethod() {
        SecondChallenge secondChallenge = new SecondChallenge();

        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(5.0, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 3.0)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 3)),
                () -> assertDoesNotThrow( () -> secondChallenge.probablyIWillThrowException(1, 1))
        );
    }
}
