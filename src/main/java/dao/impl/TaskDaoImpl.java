package dao.impl;

import dao.TaskDao;
import entity.Task;
import lombok.val;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Optional<Task> findById(long taskId) {
        return Optional.of(sessionFactory
                .getCurrentSession()
                .get(Task.class, taskId));
    }

    public Set<Task> findByUserId(long userId) {
        val criteriaBuilder = sessionFactory.getCriteriaBuilder();
        val criteriaQuery = criteriaBuilder.createQuery(Task.class);
        val root = criteriaQuery.from(Task.class);
        val rest = criteriaBuilder.equal(root.get("ownerId"), userId);
        criteriaQuery.select(root).where(rest);
        return sessionFactory
                .getCurrentSession()
                .createQuery(criteriaQuery)
                .getResultStream()
                .collect(Collectors.toSet());
    }

    public void putTask(Task task) {
        sessionFactory
                .getCurrentSession()
                .save(task);
    }
}
