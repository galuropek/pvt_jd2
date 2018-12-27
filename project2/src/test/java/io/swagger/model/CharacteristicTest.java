package io.swagger.model;

import io.swagger.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CharacteristicTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }

    @Test
    public void createInstance(){
        Characteristic characteristic = new Characteristic();
        characteristic.setName("Name");
        characteristic.setValue("Value");

        Characteristic characteristic2 = new Characteristic();
        characteristic2.setName("Name2");
        characteristic2.setValue("Value");

        try {
            session.beginTransaction();
            session.saveOrUpdate(characteristic);
            session.saveOrUpdate(characteristic2);
            session.getTransaction().commit();
            assertNotNull(characteristic.getName());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @After
    public void tearDown() throws Exception {
        if (session != null || session.isOpen()) {
            session.close();
            session = null;
        }
    }
}