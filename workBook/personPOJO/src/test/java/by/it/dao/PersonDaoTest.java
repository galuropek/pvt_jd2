package by.it.dao;

import by.it.pojos.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonDaoTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void savePerson() {

        Person person1 = PersonDao.savePerson(new Person(null, 01, "TestName_01", "Surname_01"));
        assertEquals("TestName_01", person1.getName());
        assertNotNull(person1.getId());
        System.out.println(person1);
    }
}