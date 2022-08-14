package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVING_TASK = "Driving task";
    public static final String PAINTING_TASK = "Painting task";
    public static final String SHOPPING_TASK = "Shopping task";

    public Task prepareTask(String taskName) {
        switch (taskName) {
            case DRIVING_TASK:
                return new DrivingTask("Go to the airport", "Krakow", "Car");
            case PAINTING_TASK:
                return new PaintingTask("Change colors of walls", "Red", "Living Room");
            case SHOPPING_TASK:
                return new ShoppingTask("Lidl shopping", "Tomato", 10);
            default:
                return null;
        }
    }
}
