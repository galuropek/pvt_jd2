package io.swagger.dao;

import io.swagger.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CustomerDaoImpl<T> extends BaseDaoImpl {

    private static Logger log = Logger.getLogger(Customer.class.getName());

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> find() {
        log.info("Call find()");
        return openSession().createQuery("from Customer").list();
    }

    public void save(T item) {
        openSession().saveOrUpdate(item);
    }
}
