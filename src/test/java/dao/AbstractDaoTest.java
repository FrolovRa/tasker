package dao;

import configuration.AppConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppConfig.class)
public abstract class AbstractDaoTest {
    @Autowired
    UserDao userDao;

    @Autowired
    TaskDao taskDao;
}
