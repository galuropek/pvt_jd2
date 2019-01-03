package io.swagger.model;

import io.swagger.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.threeten.bp.OffsetDateTime;

import static org.junit.Assert.*;

public class CustomerTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }

    @Test
    public void getInstance() {
        Customer customer = new Customer();

        // set string fields ===========================
        initStringFields(customer);

        // set valid for
        initValidFor(customer);

        try {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
            assertNotNull(customer.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        System.out.println(customer);
    }

    private void initValidFor(Customer customer) {
        TimePeriod timePeriod = new TimePeriod();
        OffsetDateTime startDateTime = OffsetDateTime.now();
        timePeriod.setStartDateTime(startDateTime);
        OffsetDateTime endDateTime = OffsetDateTime.now();
        timePeriod.setEndDateTime(endDateTime);
        customer.setValidFor(timePeriod);
    }

    private void initStringFields(Customer customer) {
        customer.setName("Name");
        customer.setHref("Href");
        customer.setStatus("Status-Test");
        customer.setStatusReason("Status-reason");
    }

    @After
    public void tearDown() throws Exception {
        if (session != null || session.isOpen()) {
            session.close();
            session = null;
        }
    }
}