package dao;

import dao.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TaskDao {
    Task findById(long taskId);

    Set<Task> findByUserId(long userId);
}
