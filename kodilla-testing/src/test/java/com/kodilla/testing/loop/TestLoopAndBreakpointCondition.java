package com.kodilla.testing.loop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLoopAndBreakpointCondition {

    @Test
    void testBreakpointCondition() {
        long sum =0;

        for(int n= 0; n<1000; n++) {
            sum += n;
            System.out.println("N = " + n + " SUM: " + sum);
        }
            Assertions.assertEquals(499500, sum);

    }
}
