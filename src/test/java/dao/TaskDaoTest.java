package dao;

import entity.Task;
import lombok.val;
import org.junit.Test;

public class TaskDaoTest extends AbstractDaoTest {

    @Test
    public void testCreateTask() {
        val task = new Task("first task", 6L);
        taskDao.putTask(task);
    }

    @Test
    public void testGetTasksByUserId() {
        val result = taskDao.findByUserId(6L);
        System.out.println(result);
    }
}
