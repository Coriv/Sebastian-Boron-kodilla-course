package com.kodilla.stream.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {

        int[] numbers = {34, 22, 64, 43, 123, 64, 674, 22, 11};

        double result = ArrayOperations.getAverage(numbers);

        assertEquals(117.44, result, 0.01);

    }
}
