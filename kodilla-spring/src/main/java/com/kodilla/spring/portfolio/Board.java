package com.kodilla.spring.portfolio;

public class Board {

    private final TaskList toDoLis;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(final TaskList toDoLis, final TaskList inProgressList, final TaskList doneList) {
        this.toDoLis = toDoLis;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoLis() {
        return toDoLis;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
