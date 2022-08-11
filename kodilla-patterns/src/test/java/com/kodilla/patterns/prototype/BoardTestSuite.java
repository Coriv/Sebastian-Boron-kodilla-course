package com.kodilla.patterns.prototype;

import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTestSuite {

    @Test
    void testToString() {
        TasksList listToDo = new TasksList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number " + n)));

        TasksList listInProgress = new TasksList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number " + n)));

        TasksList listDone = new TasksList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number " + n)));

        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        Board cloneBoard = null;
        try {
            cloneBoard = board.shallowCopy();
            cloneBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Board deepClone = null;
        try {
            deepClone = board.deepCopy();
            deepClone.setName("Project nunmber 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        board.getLists().remove(listToDo);

        System.out.println(board);
        System.out.println(cloneBoard);
        System.out.println(deepClone);

        assertEquals(2, board.getLists().size());
        assertEquals(2, cloneBoard.getLists().size());
        assertEquals(3, deepClone.getLists().size());
        assertEquals(board.getLists().size(), cloneBoard.getLists().size());
        assertNotEquals(board.getLists().size(), deepClone.getLists().size());
    }
}

