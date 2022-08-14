package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    static TaskFactory taskFactory;

    @BeforeAll
    static void taskFactory() {
        taskFactory = new TaskFactory();
    }

    @Test
    void testDrivingTask() {
        Task drivingTask = taskFactory.prepareTask(TaskFactory.DRIVING_TASK);

        String name = drivingTask.getTaskName();
        boolean isExecuted = drivingTask.isTaskExecuted();

        assertEquals("Go to the airport", name);
        assertFalse(isExecuted);
    }

    @Test
    void testShoppingTask() {
        Task shoppingTask = taskFactory.prepareTask(TaskFactory.SHOPPING_TASK);

        String name = shoppingTask.getTaskName();
        shoppingTask.executeTask();
        shoppingTask.executeTask();
        boolean isExecuted = shoppingTask.isTaskExecuted();

        assertEquals("Lidl shopping", name);
        assertTrue(isExecuted);
    }

    @Test
    void testPaintingTask() {
        Task paintingTask = taskFactory.prepareTask(TaskFactory.PAINTING_TASK);

        String name = paintingTask.getTaskName();
        boolean isExecuted = paintingTask.isTaskExecuted();

        assertEquals("Change colors of walls", name);
        assertFalse(isExecuted);
    }
}
