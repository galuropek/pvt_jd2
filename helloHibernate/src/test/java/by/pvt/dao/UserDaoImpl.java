package by.pvt.dao;

import by.pvt.pojo.User;
import by.pvt.pojo.UserDetails;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.sql.Timestamp;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoImpl {

    DaoImpl<User> userDao;

    @Before
    public void setUp() {
        userDao = new DaoImpl<>(User.class);
    }

    @Test
    public void step1_createNewUser() {

        User user = new User();
        user.setUserLogin("test_user");
        user.setUserEmail("qwerty@mail.com");

        UserDetails userDetails = new UserDetails();
        userDetails.setPassword("qwerty");
        userDetails.setLoginAttempts(3);
        userDetails.setExpiratedDate(new Timestamp(System.currentTimeMillis()));

        user.setUserDetails(userDetails);
        userDetails.setUser(user);

        userDao.saveOrUpdate(user);

        assertTrue(user.getId() > 0);
    }

    @Test
    public void step2_findUser() {

        User user = userDao.find(1L);
        assertNotNull(user);
        assertNotNull(user.getUserDetails());
        System.out.println(user.getUserEmail() + " " + user.getUserLogin());
    }

    @Test
    public void step3_updateUser() {

        User user = userDao.load(1L);
        assertTrue(user.getUserLogin().equals("test_user"));
        assertTrue("qwerty".equals(user.getUserDetails().getPassword()));
        user.setUserLogin("updated_user");
        user.getUserDetails().setPassword("updated_password");
        userDao.saveOrUpdate(user);

        User user2 = userDao.load(1L);
        assertTrue(user2.getUserLogin().equals("updated_user"));

        assertTrue("updated_password".equals(user2.getUserDetails().getPassword()));
    }

    @Test
    public void step4_deleteUser() {

        User user = userDao.load(1L);
        userDao.delete(user.getId());

        User user2 = userDao.find(1L);

        assertNull(user2);
    }

    @After
    public void tearDown() {
        userDao.isTestInstance = false;
        userDao = null;
    }
}
