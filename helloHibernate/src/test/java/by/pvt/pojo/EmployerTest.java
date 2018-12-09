package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployerTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }

    @Test
    public void createInstance(){
        Employer employer = new Employer();
        employer.setName("Ivan");
        employer.setCorporatePhoneNumber("312-34-21");

        session.beginTransaction();
        session.saveOrUpdate(employer);
    }

    @After
    public void tearDown() throws Exception {
    }
}