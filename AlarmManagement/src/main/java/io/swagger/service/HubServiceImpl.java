package io.swagger.service;

import io.swagger.dao.AlarmDaoImpl;
import io.swagger.dao.HubDaoImpl;
import io.swagger.model.Alarm;
import io.swagger.model.Hub;
import io.swagger.util.PropertiesUtils;
import io.swagger.util.Validator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class HubServiceImpl extends BaseServiceImpl {

    private static Logger log = Logger.getLogger(AlarmServiceImpl.class.getName());

    private final HubDaoImpl hubDao;

    private Validator validator;

    @Autowired
    public HubServiceImpl(HubDaoImpl hubDao) {
        this.hubDao = hubDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Hub> list() {
        log.info("list() hubDao=" + hubDao);
        return hubDao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    @SuppressWarnings("unchecked")
    public void save(Hub item) {
        log.info("save(): " + item);
        hubDao.save(item);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, value = "txManager")
    @SuppressWarnings("unchecked")
    public void create(List<Hub> items) {
        log.info("create(): " + items);
        for (Hub item : items) {
            hubDao.save(item);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Hub retrieve(Serializable id) {
        Hub hub = hubDao.get(id);
        log.info("delete: " + hub);
        return hub;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Serializable id) {
        Hub hub = hubDao.get(id);
        log.info("delete: " + hub);
        hubDao.delete(hub);
    }

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void update(Serializable id, Alarm alarmEdited) {
//        Alarm alarmOriginal = alarmDao.get(id);
//        Alarm alarmUpdated = PropertiesUtils.updateProperties(alarmOriginal, alarmEdited);
//        BeanUtils.copyProperties(alarmUpdated, alarmOriginal);
//        alarmOriginal.setId((Long) id);
//        log.info("update(): " + alarmOriginal);
//        alarmDao.update(alarmOriginal);
//    }
}
