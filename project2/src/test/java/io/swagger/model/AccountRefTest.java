package io.swagger.model;

import io.swagger.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountRefTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }

    @Test
    public void createInstance() {
        AccountRef accountRef = initAccountRef("0");
        try {
            session.beginTransaction();
            session.saveOrUpdate(accountRef);
            session.getTransaction().commit();
            assertNotNull(accountRef.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        System.out.println(accountRef);
    }

    private AccountRef initAccountRef(String prefix) {
        AccountRef accountRef = new AccountRef();
        accountRef.setName("TestName" + prefix);
        accountRef.setDescription("TestDescription" + prefix);
        accountRef.setHref("TestHref" + prefix);
        return accountRef;
    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}