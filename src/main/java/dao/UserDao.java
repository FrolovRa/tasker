package dao;

import dao.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User findById(long userId);
}
