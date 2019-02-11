package by.carrental.project.dao.impl;

import by.carrental.project.configuration.HibernateXMLConfTest;
import by.carrental.project.model.User;
import by.carrental.project.util.UserInit;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateXMLConfTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoImplTest {

    @MockBean
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Autowired
    UserDaoImpl userDao;

    @Test
    public void step1_save() {
        User user = UserInit.init("1");
        userDao.save(user);
        System.out.println(user);
        assertNotNull(user.getId());
        assertEquals("Login1", user.getLogin());
        assertEquals("Password1", user.getPassword());

        assertNotNull(user.getDetails().getId());
        assertEquals("Name1", user.getDetails().getFirstName());

        assertNotNull(user.getDetails().getAddress().getStreet());
        assertEquals("Street1", user.getDetails().getAddress().getStreet());

        System.out.println("===================================================\n" +
                "test save():\n" +
                user + "\n===================================================");
    }

    @Test
    public void step2_get() {
        User user = UserInit.init("2");
        userDao.save(user);
        assertNotNull(user.getId());
        User gotUser = userDao.get(user.getId());
        assertEquals(user.getId(), gotUser.getId());
        assertEquals(user, gotUser);
        System.out.println("===================================================\n" +
                "test get():\n" +
                gotUser + "\n===================================================");
    }

    @Test
    public void step3_getAll() {
        User user1 = UserInit.init("1");
        User user2 = UserInit.init("2");
        User user3 = UserInit.init("3");
        userDao.save(user1);
        userDao.save(user2);
        userDao.save(user3);

        List<User> users = userDao.getAll();
        assertEquals(3, users.size());
        System.out.println("===================================================\n" +
                "test getAll():\n");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("\n===================================================");
    }

    @Test
    public void step4_delete() {
        User user = UserInit.init("1");
        userDao.save(user);
        assertNotNull(user.getId());

        User gottenUser = userDao.get(user.getId());
        assertEquals(user, gottenUser);

        System.out.println("===================================================\n" +
                "test delete():\n" +
                "before delete:\n" + user);

        userDao.delete(user);

        User userAfterDelete = userDao.get(user.getId());
        assertNull(userAfterDelete);
        System.out.println("after delete:\n" + userAfterDelete);
        System.out.println("\n===================================================");
    }

    @Test
    public void step5_update() {
        User user = UserInit.init("1");
        userDao.save(user);
        assertNotNull(user.getId());
        assertEquals("Login1", user.getLogin());
        assertEquals("Password1", user.getPassword());

        User gottenUser = userDao.get(user.getId());
        assertEquals(user, gottenUser);
        gottenUser.setLogin("Update");
        userDao.update(gottenUser);
        System.out.println("===================================================\n" +
                "test update():\n" + "before update:\n" +
                user + "\n===================================================");

        User updatedUser = userDao.get(user.getId());
        assertEquals(user.getId(), updatedUser.getId());
        assertEquals("Update", updatedUser.getLogin());
        System.out.println("===================================================\n" +
                "test update():\n" + "after update:\n" +
                updatedUser + "\n===================================================");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}
