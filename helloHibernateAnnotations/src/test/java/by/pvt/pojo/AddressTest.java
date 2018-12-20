package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }

    @Test
    public void createInstance() {
        Address address = new Address("Minsk",
                "Stroiteley",
                "5",
                24);

        try {
            session.beginTransaction();
            session.saveOrUpdate(address);
            session.getTransaction().commit();
            assertTrue(address.getId() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @After
    public void tearDown() throws Exception {
        if(session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}