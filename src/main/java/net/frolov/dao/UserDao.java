package net.frolov.dao;

import net.frolov.entity.User;

public interface UserDao {
    User findById(long userId);

    User createUser();
}
