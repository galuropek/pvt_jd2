package by.pvt.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class PersonTest {

    Person person1 = new Person();
    Person person2 = new Person();
    SessionFactory sessionFactory;

    private void initPerson(Person person) {
        person.setAge(35);
        person.setDateOfBirth(new GregorianCalendar(1990, 1, 1).getTime());
        person.setId("101");
        person.setName("Natalia");
        person.setSecondName("Ivanova");
        person.setTitles(List.of("Mrs", "Frau", "Dr."));
    }

    @Before
    public void setUp() throws Exception {
        initPerson(person1);
        initPerson(person2);
        setUpHibernate();
    }

    private void setUpHibernate() {
        StandardServiceRegistry standardServiceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

        sessionFactory = new MetadataSources(standardServiceRegistry)
                .buildMetadata()
                .buildSessionFactory();
    }

    @After
    public void tearDown() throws Exception {
        // close session and kill by garbage collector
//        sessionFactory.close();
//        sessionFactory = null;
    }

    @Test
    public void testHashCode() {
        assertEquals(person1.hashCode(), person2.hashCode());
        assertEquals(person2.hashCode(), person1.hashCode());

        assertEquals(person1.hashCode(), person1.hashCode());
        assertEquals(person2.hashCode(), person2.hashCode());
    }

    @Test
    public void testEquals() {
        assertTrue(person1.equals(person1));
        assertTrue(person2.equals(person2));

        assertTrue(person1.equals(person2) && person2.equals(person1));

        assertFalse(person1.equals(null));
        assertFalse(person2.equals(null));
    }

    @Test
    public void testHibernate() {

        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            Serializable id1 = session.save(person1);
            Serializable id2 = session.save(person2);
            System.out.println("My POJO id: " + id1);
            System.out.println("My POJO id: " + id2);

            assertNotNull(id1);
            assertNotNull(id2);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }

        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();
        List<Person> list = session2.createQuery("from Person ").list();

        assertTrue(list.size() > 0);

        for (Person p : list) {
            System.out.println("Person: " + p);
        }
        session2.getTransaction().commit();
        session2.close();
    }
}