package dao;

import net.frolov.entity.Task;
import lombok.val;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;

public class TaskDaoTest extends AbstractDaoTest {

    @Test
    public void testCreateTask() {
        val task = new Task("first task", 2L);

        val taskFromDb = taskDao.saveTask(task);

        assertEquals(task, taskFromDb);
    }

    @Test
    public void testGetTasksByUserId() {
        val taskOne = new Task("task one", 1L);
        taskOne.setId(1L);
        taskOne.setCreated(ZonedDateTime.parse("2019-12-09T18:47:52+03:00[Europe/Moscow]"));
        val taskTwo = new Task("task two", 1L);
        taskTwo.setId(2L);
        taskTwo.setCreated(ZonedDateTime.parse("2019-12-09T18:47:52+03:00[Europe/Moscow]"));
        val tasks = Stream
                .of(taskOne, taskTwo)
                .collect(toSet());

        val userTasks = taskDao.findTasksByUserId(1L);

        assertEquals(tasks, userTasks);
    }
}
