package dao;

import entity.User;

public interface UserDao {
    User findById(long userId);

    User createUser();
}
