package io.swagger.model;

import io.swagger.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgreementRefTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }

    @Test
    public void createInstance() {
        AgreementRef agreementRef = initAgreementRef("0");
        try {
            session.beginTransaction();
            session.saveOrUpdate(agreementRef);
            session.getTransaction().commit();
            assertNotNull(agreementRef.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        System.out.println(agreementRef);
    }

    private AgreementRef initAgreementRef(String prefix) {
        AgreementRef agreementRef = new AgreementRef();
        agreementRef.setName("Name" + prefix);
        agreementRef.setHref("Href" + prefix);
        return agreementRef;
    }

    @After
    public void tearDown() throws Exception {
        if (session == null || session.isOpen()) {
            session.close();
            session = null;
        }
    }
}