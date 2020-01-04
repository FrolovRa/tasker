package net.frolov.service.impl;

import net.frolov.dao.UserDao;
import net.frolov.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import net.frolov.service.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findById(long userId) {
        return userDao.findById(userId);
    }

    public User createUser() {
        return userDao.createUser();
    }
}
