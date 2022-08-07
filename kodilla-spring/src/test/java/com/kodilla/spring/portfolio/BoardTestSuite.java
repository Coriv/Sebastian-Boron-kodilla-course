package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testTaskAdd() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = (Board) context.getBean(Board.class);

        board.getToDoLis().getTasks().add("Task to do one");
        board.getInProgressList().getTasks().add("Task in progress one");
        board.getDoneList().getTasks().add("Done task one");

        System.out.println(board.getToDoLis().getTasks());
        System.out.println(board.getInProgressList().getTasks());
        System.out.println(board.getDoneList().getTasks());

    }
}
