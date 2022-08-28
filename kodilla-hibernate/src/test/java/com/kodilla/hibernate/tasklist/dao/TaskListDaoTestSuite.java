package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    public static final String TASK_NAME = "Task number 1";
    public static final String LISTNAME = "To do list";
    public static final String DESCRIPTION = "Hibernate - testing";

    @Test
    void testFindByListName() {
        TaskList taskList = new TaskList(TASK_NAME, DESCRIPTION);
        taskListDao.save(taskList);

        List<TaskList> readTaskList = taskListDao.findByListName(TASK_NAME);

        String result = readTaskList.get(0).getListName();

        assertEquals(1, readTaskList.size());
        assertEquals(result, taskList.getListName());

        int id = taskList.getId();
        taskListDao.deleteById(id);
    }

    @Test
    void testTaskListDaoSaveWithTasks() {

        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();

        assertNotEquals(0, id);

        taskListDao.deleteById(id);
    }
}
