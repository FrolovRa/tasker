package dao.impl;

import dao.TaskDao;
import dao.entity.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Set;

@Transactional
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Task findById(long taskId) {
        return sessionFactory
                .getCurrentSession()
                .get(Task.class, taskId);
    }

    public Set<Task> findByUserId(long userId) {
        return null;
    }
}
