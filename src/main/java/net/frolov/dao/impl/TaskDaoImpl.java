package net.frolov.dao.impl;

import net.frolov.dao.TaskDao;
import net.frolov.entity.Task;
import lombok.val;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Task> findById(long taskId) {
        return sessionFactory
                .getCurrentSession()
                .byId(Task.class)
                .loadOptional(taskId);
    }

    @Override
    public Set<Task> findTasksByUserId(long userId) {
        final val criteriaBuilder = sessionFactory.getCriteriaBuilder();
        final val criteriaQuery = criteriaBuilder.createQuery(Task.class);
        final val root = criteriaQuery.from(Task.class);
        final val condition = criteriaBuilder.equal(root.get("ownerId"), userId);
        criteriaQuery.select(root).where(condition);
        return sessionFactory
                .getCurrentSession()
                .createQuery(criteriaQuery)
                .getResultStream()
                .collect(Collectors.toSet());
    }

    @Override
    public Task saveTask(Task task) {
        final val session = sessionFactory.getCurrentSession();
        final val id = session.save(task);
        return session.get(Task.class, id);
    }
}
