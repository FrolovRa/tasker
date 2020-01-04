package net.frolov.dao;

import net.frolov.entity.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findById(long userId);

    User saveUser(User user);
}
