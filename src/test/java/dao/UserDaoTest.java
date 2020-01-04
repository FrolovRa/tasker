package dao;


import lombok.val;
import net.frolov.entity.User;
import org.junit.Test;

public class UserDaoTest extends AbstractDaoTest {

    @Test
    public void testCreateUser() {
        val result = userDao.saveUser(new User());
        System.out.println(result);
    }

    @Test
    public void testFindById() {
        val r = userDao.findById(1L);
        System.out.println(r);
    }
}
