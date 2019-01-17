package io.swagger.dao;

import io.swagger.model.Alarm;
import io.swagger.model.AlarmedObject;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class AlarmedObjectDaoImpl extends BaseDaoImpl {

    private static Logger log = Logger.getLogger(AlarmDaoImpl.class.getName());

    private Class<AlarmedObject> tClass = AlarmedObject.class;

    @Autowired
    public AlarmedObjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List getAll() {
        log.info("Call getAll()");
        return openSession().createQuery("from AlarmedObject").list();
    }

    @Override
    public Object get(Serializable id) {
        log.info("Call get()");
        return openSession().find(tClass, id);
    }
}
