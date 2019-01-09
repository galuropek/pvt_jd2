package io.swagger.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class BaseDaoImpl<T> {

    @Autowired
    SessionFactory sessionFactory;

    Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    abstract List<T> getAll();

    abstract T get(Serializable id);

    public void save(T item) {
        openSession().saveOrUpdate(item);
    }

    public void update(T item) {
        openSession().update(item);
    }

    public void delete(T item) {
        openSession().delete(item);
    }
}
