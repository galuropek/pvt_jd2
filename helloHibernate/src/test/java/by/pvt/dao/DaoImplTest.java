package by.pvt.dao;

import by.pvt.pojo.Person;
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
    }

    @Test
    public void find() {

    }
}