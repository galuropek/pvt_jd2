package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeadquarterTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }

    @Test
    public void createInstance(){
        Headquarter headquarter = new Headquarter();
        headquarter.setCompanyName("Romashka");
        headquarter.setSiteUrl("WWW.romashka.com");
        headquarter.setDirectorName("Ivanov");
        headquarter.setBankAccount("2h32jh423g234jg32f");

        try {
            session.beginTransaction();
            session.saveOrUpdate(headquarter);
            session.getTransaction().commit();
            assertNotNull(headquarter.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()){
            session.close();
            session = null;
        }
    }
}