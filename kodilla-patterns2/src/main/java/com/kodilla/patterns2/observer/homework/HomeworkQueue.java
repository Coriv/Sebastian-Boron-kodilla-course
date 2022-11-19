package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements Observable {
    private final List<Observer> observers;
    private final ArrayDeque<HomeworkTask> tasks;
    private final Student student;

    public HomeworkQueue(Student student) {
        tasks = new ArrayDeque<>();
        observers = new ArrayList<>();
        this.student = student;
    }

    public void addTask(HomeworkTask task) {
        tasks.offerLast(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public ArrayDeque<HomeworkTask> getTasks() {
        return tasks;
    }

    public Student getStudent() {
        return student;
    }
}
