package dao;


import lombok.val;
import org.junit.Test;

public class UserDaoTest extends AbstractDaoTest {

    @Test
    public void testCreateUser() {
        val result = userDao.createUser();
        System.out.println(result);
    }

    @Test
    public void testFindById() {
        val r = userDao.findById(6L);
        System.out.println(r);
    }
}
