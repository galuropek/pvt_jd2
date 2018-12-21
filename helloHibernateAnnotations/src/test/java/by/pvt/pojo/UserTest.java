package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;

import static org.junit.Assert.*;

public class UserTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }

    @Test
    public void createIstance() {

        User user = new User();
        user.setUserLogin("User_test");
        user.setUserEmail("qwerty@mail.com");

        UserDetails userDetails = new UserDetails();
        userDetails.setPassword("12345678");
        userDetails.setLoginAttempts(3);
        userDetails.setExpiratedDate(new Timestamp(System.currentTimeMillis()));

        user.setUserDetails(userDetails);
        userDetails.setUser(user);

        try {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.saveOrUpdate(userDetails);
            session.getTransaction().commit();
            assertTrue(user.getId() > 0);
            assertTrue(userDetails.getId() > 0);
            assertEquals(user.getId(), userDetails.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}