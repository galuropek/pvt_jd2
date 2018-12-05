package by.pvt.dao;

import by.pvt.pojo.Person;
import by.pvt.util.HibernateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class DaoImplTest {

    DaoImpl<Person> dao;

    @Before
    public void setUp() throws Exception {
        dao = new DaoImpl<>(Person.class);
    }

    @After
    public void tearDown() throws Exception {
        dao = null;
    }

    @Test
    public void saveOrUpdate() {

        assertNull(dao.saveOrUpdate(null));

        assertNotNull(dao.saveOrUpdate(new Person()));

        Person person = new Person();
        assertNull(person.getId());
        Person person2 = dao.saveOrUpdate(person);
        assertEquals(person, person2);
        assertNotNull(person.getId());

        person2.setSecondName("Petrova");
        Person person3 = dao.saveOrUpdate(person2);
        assertEquals("Petrova", person3.getSecondName());
    }

    @Test
    public void load() {

        try {
            dao.load(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), IllegalArgumentException.class);
        }

        Person person = dao.saveOrUpdate(new Person());
        assertNotNull(dao.load(person.getId()));

        Person person2 = dao.load(person.getId());
        assertEquals(person, person2);
    }

    @Test
    public void find() {

        assertNull(dao.find(null));
        assertNull(dao.find(101));

        Person person = dao.saveOrUpdate(new Person());
        assertNotNull(dao.load(person.getId()));

        Person person2 = dao.load(person.getId());
        assertEquals(person, person2);
    }

    @Test
    public void updateName() {

        Person person = new Person();
        person.setName("Vasya");
        person.setSecondName("Ivanov");
        person = dao.saveOrUpdate(person);
        assertNotNull(person.getId());
        dao.updateName(person.getId(), "Petya");
//        person = dao.load(person.getId());
        assertEquals(person.getName(), "Petya");

        //TODO: check why after rollback Persin POJO has been disconnected from session and lost state
        try {
            dao.updateName(null, null);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(e instanceof IllegalArgumentException);
            HibernateUtil.getInstance().getSession().getTransaction().rollback();
        }
    }

    @Test
    public void delete(){

        Person person = new Person();
        Serializable id = dao.saveOrUpdate(person).getId();
        assertNotNull(id);

        dao.delete(id);

        assertNull(dao.find(id));
        System.out.println(person);
    }
}