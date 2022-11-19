package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer{
    private final String name;
    private int updateCounter = 0;

    public Mentor(String name) {
        this.name = name;
    }
    @Override
    public void update(HomeworkQueue homeworkQueue) {
        System.out.println("You have new task to verify: " + homeworkQueue.getTasks().peekLast().getName() + "/n" +
                "From student: " + homeworkQueue.getStudent().getName() + "\n" +
                "In total task to check: " + homeworkQueue.getTasks().size());
        updateCounter++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCounter() {
        return updateCounter;
    }
}
