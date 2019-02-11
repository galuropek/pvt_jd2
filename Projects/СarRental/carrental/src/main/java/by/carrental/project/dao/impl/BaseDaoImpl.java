package by.carrental.project.dao.impl;

import by.carrental.project.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private static Logger log = Logger.getLogger(BaseDaoImpl.class.getName());

    @Autowired
    SessionFactory sessionFactory;

    private Class<T> aClass;

    BaseDaoImpl(Class<T> aClass) {
        this.aClass = aClass;
    }

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<T> getAll() {
        String name = aClass.getSimpleName();
        List items = openSession().createQuery("from " + name).list();
        log.info(aClass + "getAll():\n" + items);
        return items;
    }

    public T get(Serializable id) {
        T item = openSession().get(aClass, id);
        log.info(aClass + "get():\n" + item);
        return item;
    }

    public void save(T item) {
        openSession().saveOrUpdate(item);
        log.info(aClass + "get():\n" + item);
    }

    public void update(T item) {
        openSession().update(item);
        log.info(aClass + "get():\n" + item);
    }

    public void delete(T item) {
        openSession().delete(item);
        log.info(aClass + "get():\n" + item);
    }
}
