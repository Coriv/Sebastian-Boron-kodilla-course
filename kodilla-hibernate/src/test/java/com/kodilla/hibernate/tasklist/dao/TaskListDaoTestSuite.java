package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    public static final String TASK_NAME = "Task number 1";
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
}
