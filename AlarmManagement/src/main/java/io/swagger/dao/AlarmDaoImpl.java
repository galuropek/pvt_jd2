package io.swagger.dao;

import io.swagger.model.Alarm;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class AlarmDaoImpl extends BaseDaoImpl{

    private static Logger log = Logger.getLogger(AlarmDaoImpl.class.getName());

    private Class<Alarm> tClass = Alarm.class;

    @Autowired
    public AlarmDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Alarm> getAll() {
        log.info("Call getAll()");
        return openSession().createQuery("from Alarm").list();
    }

    @Override
    public Alarm get(Serializable id) {
        log.info("Call get()");
        return openSession().find(tClass, id);
    }
}
