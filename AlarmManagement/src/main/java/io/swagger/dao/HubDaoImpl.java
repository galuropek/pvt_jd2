package io.swagger.dao;

import io.swagger.model.Alarm;
import io.swagger.model.Hub;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class HubDaoImpl extends BaseDaoImpl{

    private static Logger log = Logger.getLogger(AlarmDaoImpl.class.getName());

    private Class<Hub> tClass = Hub.class;

    @Autowired
    public HubDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Hub> getAll() {
        log.info("Call getAll()");
        return openSession().createQuery("from alarm_management.hub").list();
    }

    @Override
    public Hub get(Serializable id) {
        log.info("Call get()");
        return openSession().find(tClass, id);
    }
}
