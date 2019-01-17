package io.swagger.dao;

import io.swagger.model.AffectedService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class AffectedServiceDaoImpl extends BaseDaoImpl {

    private static Logger log = Logger.getLogger(AffectedServiceDaoImpl.class.getName());

    private Class<AffectedService> tClass = AffectedService.class;

    @Autowired
    public AffectedServiceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List getAll() {
        log.info("Call getAll()");
        return openSession().createQuery("from AffectedService").list();
    }

    @Override
    public Object get(Serializable id) {
        log.info("Call get()");
        return openSession().find(tClass, id);
    }
}
