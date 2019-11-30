package dao.impl;

import dao.UserDao;
import dao.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User findById(long userId) {
        return sessionFactory
                .getCurrentSession()
                .get(User.class, userId);
    }
}
