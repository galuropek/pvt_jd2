package by.pvt.pojo;

import by.pvt.util.HibernateUtil;
import by.pvt.util.TestData;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class WorkerTest {

    Session session;

    @Before
    public void setUp() throws Exception {
        session = HibernateUtil.getInstance().getSession();
    }

    @Test
    public void createInstance() {
        Worker worker = createWorker("");

        try {
            session.beginTransaction();
            session.saveOrUpdate(worker);
            session.getTransaction().commit();
            assertNotNull(worker.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Test
    public void testCriteria() {
        @TestData
        Worker worker1 = createWorker("1");
        @TestData
        Worker worker2 = createWorker("2");
        @TestData
        Worker worker3 = createWorker("3");
        @TestData
        Worker worker4 = createWorker("4");
        @TestData
        Worker worker5 = createWorker("5");

        try {
            session.beginTransaction();
            session.saveOrUpdate(worker1);
            session.saveOrUpdate(worker2);
            session.saveOrUpdate(worker3);
            session.saveOrUpdate(worker4);
            session.saveOrUpdate(worker5);
            session.getTransaction().commit();
            assertNotNull(worker1.getId());
            assertNotNull(worker2.getId());
            assertNotNull(worker3.getId());
            assertNotNull(worker4.getId());
            assertNotNull(worker5.getId());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        //session for
        Criteria criteria = session.createCriteria(Worker.class);
        criteria.add(Restrictions.ge("salary", new BigDecimal(1_000.00)));
        List list = criteria.list();
        System.out.println(list);

        criteria = session.createCriteria(Worker.class);
        criteria.setProjection(Projections.rowCount());
        System.out.println(criteria.list());
    }


    private Worker createWorker(String postfix) {
        if (postfix == null) postfix = "";
        Worker worker = new Worker();
        worker.setName("Worker name" + postfix);
        worker.setSecondName("Worker second name" + postfix);
        worker.setCompanyName("OOO Romashka");
        worker.setSalary(BigDecimal.valueOf(500 + Math.random() * 1000));
        return worker;
    }

    @After
    public void tearDown() throws Exception {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }
}