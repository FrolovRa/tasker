package dao.impl;

import dao.UserDao;
import dao.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User findById(long userId) {
        return sessionFactory
                .openSession()
                .get(User.class, userId);
    }

    @Transactional
    public User createUser() {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(new User());
        return session.get(User.class, id);
    }
}
