package dao;

import configuration.TestApplicationConfig;
import net.frolov.dao.TaskDao;
import net.frolov.dao.UserDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestApplicationConfig.class)
public abstract class AbstractDaoTest {
    @Autowired
    UserDao userDao;

    @Autowired
    TaskDao taskDao;
}
