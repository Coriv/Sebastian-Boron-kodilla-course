package com.kodilla.patterns2.observer.homework;

public class HomeworkTask {
    private final String name;
    private final String description;

    public HomeworkTask(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
