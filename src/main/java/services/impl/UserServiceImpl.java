package services.impl;

import dao.UserDao;
import dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import services.UserService;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findById(long userId) {
        return userDao.findById(userId);
    }
}
