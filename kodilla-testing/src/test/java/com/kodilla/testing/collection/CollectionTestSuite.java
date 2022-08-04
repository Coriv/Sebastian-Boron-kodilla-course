package com.kodilla.testing.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.*;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    List<Integer> list = new ArrayList<>();
    OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

    @DisplayName("Test when the list is empty")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        List<Integer> test = oddNumbersExterminator.exterminate(list);
        System.out.println("Size of list: " + test.size());

    }

    @DisplayName("Test with filled list")
    @Test
    void testOddNumbersExterminatorNormalList() {
        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> test = oddNumbersExterminator.exterminate(list);
        System.out.println(test);
    }

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }
}