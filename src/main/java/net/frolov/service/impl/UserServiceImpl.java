package net.frolov.service.impl;

import net.frolov.dao.UserDao;
import net.frolov.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import net.frolov.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(long userId) {
        return userDao.findById(userId);
    }

    @Override
    public User createUser() {
        return userDao.createUser();
    }
}
