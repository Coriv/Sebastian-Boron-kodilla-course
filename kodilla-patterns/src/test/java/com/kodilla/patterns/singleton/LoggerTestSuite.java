package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    public static void createLog() {
        logger = Logger.INSTANCE;
        logger.log("log_nr_1");
    }

    @Test
    void testGetLog() {
        String result = logger.getLastLog();
        assertEquals("log_nr_1", result);
    }
}
