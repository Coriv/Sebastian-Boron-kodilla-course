package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkQueueTestSuite {

    @Test
    void addingNewTaskToQueueTest() {

        //Given
        HomeworkTask task1 = new HomeworkTask("Facade pattern", "Prepare facade for task with module 17 - Spring and Hibernate");
        HomeworkTask task2 = new HomeworkTask("Decorator pattern", "Prepare a program to service a pizza orders");
        HomeworkTask task3 = new HomeworkTask("Aspect Oriented Programming", "Prepare method which will log all logging events");
        HomeworkTask task4 = new HomeworkTask("Observer pattern", "Prepare kodilla tasks system");

        Student student1 = new Student("Mark Kovalsky");
        Student student2 = new Student("Pawel Zaorski");
        Student student3 = new Student("Ewelina Krychowiak");
        Student student4 = new Student("Eliza Mogala");

        Mentor mentor1 = new Mentor("Ko Jin");
        Mentor mentor2 = new Mentor("Sen Sei");

        HomeworkQueue que1 = new HomeworkQueue(student1);
        HomeworkQueue que2 = new HomeworkQueue(student2);
        HomeworkQueue que3 = new HomeworkQueue(student3);
        HomeworkQueue que4 = new HomeworkQueue(student4);

        que1.registerObserver(mentor1);
        que2.registerObserver(mentor1);
        que3.registerObserver(mentor2);
        que4.registerObserver(mentor2);

        //when
        que1.addTask(task1);
        que1.addTask(task4);

        que2.addTask(task1);
        que2.addTask(task2);
        que2.addTask(task3);
        que2.addTask(task4);

        que3.addTask(task2);
        que3.addTask(task1);
        que3.addTask(task4);

        que4.addTask(task1);
        que4.addTask(task3);

        //then
        assertEquals(6, mentor1.getUpdateCounter());
        assertEquals(5, mentor2.getUpdateCounter());

    }
}