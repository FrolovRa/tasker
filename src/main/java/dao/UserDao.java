package dao;

import dao.entity.User;

public interface UserDao {
    User findById(long userId);

    User createUser();
}
