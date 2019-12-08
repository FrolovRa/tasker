package service.impl;

import dao.UserDao;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;

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
