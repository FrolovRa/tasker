package net.frolov.dao.impl;

import lombok.val;
import net.frolov.dao.UserDao;
import net.frolov.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Optional<User> findById(long userId) {
        return sessionFactory
                .getCurrentSession()
                .byId(User.class)
                .loadOptional(userId);
    }

    public User saveUser(User user) {
        final val session = sessionFactory.getCurrentSession();
        final val id = session.save(user);
        return session.get(User.class, id);
    }
}