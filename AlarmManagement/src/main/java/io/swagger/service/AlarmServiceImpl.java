package io.swagger.service;

import io.swagger.dao.AlarmDaoImpl;
import io.swagger.model.*;
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
public class AlarmServiceImpl extends BaseServiceImpl {

    private static Logger log = Logger.getLogger(AlarmServiceImpl.class.getName());

    private final AlarmDaoImpl alarmDao;

    private Validator validator;

    @Autowired
    public AlarmServiceImpl(AlarmDaoImpl alarmDao) {
        this.alarmDao = alarmDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Alarm> list() {
        log.info("list() alarmDao=" + alarmDao);
        return alarmDao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Alarm> listFields(String fields) {
        log.info("list() alarmDao=" + alarmDao);
        return alarmDao.getAll(fields);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    @SuppressWarnings("unchecked")
    public void save(Alarm item) {
        log.info("save(): " + item);
        alarmDao.save(item);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, value = "txManager")
    @SuppressWarnings("unchecked")
    public void create(List<Alarm> items) {
        log.info("create(): " + items);
        for (Alarm item : items) {
            alarmDao.save(item);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Alarm retrieve(Serializable id) {
        Alarm alarm = alarmDao.get(id);
        log.info("delete: " + alarm);
        return alarm;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public Object retrieve(Serializable id, String fields) {
        Object alarm = alarmDao.get(id, fields);
        log.info("delete: " + alarm);
        return alarm;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void delete(Serializable id) {
        Alarm alarm = alarmDao.get(id);
        log.info("delete: " + alarm);
        alarmDao.delete(alarm);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(Serializable id, Alarm alarmEdited) {
        Alarm alarmOriginal = alarmDao.get(id);
        Alarm alarmUpdated = PropertiesUtils.updateProperties(alarmOriginal, alarmEdited);
        BeanUtils.copyProperties(alarmUpdated, alarmOriginal);
        alarmOriginal.setId((Long) id);
        log.info("update(): " + alarmOriginal);
        alarmDao.update(alarmOriginal);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void clearFieldsById(Serializable id, Alarm alarmEdited){
        Alarm alarmOriginal = alarmDao.get(id);
        Alarm alarmUpdated = PropertiesUtils.clearProperties(alarmOriginal, alarmEdited);
        BeanUtils.copyProperties(alarmUpdated, alarmOriginal);
        alarmOriginal.setId((Long) id);
        log.info("clearFieldsById(): " + alarmOriginal);
        alarmDao.update(alarmOriginal);
    }
}
