package io.swagger.service;

import io.swagger.dao.AlarmDaoImpl;
import io.swagger.dao.AlarmedObjectDaoImpl;
import io.swagger.model.Alarm;
import io.swagger.model.AlarmedObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class AlarmedObjectServiceImpl extends BaseServiceImpl {

    private static Logger log = Logger.getLogger(AlarmServiceImpl.class.getName());

    private final AlarmedObjectDaoImpl alarmedObjectDao;

    @Autowired
    public AlarmedObjectServiceImpl(AlarmedObjectDaoImpl alarmedObjectDao) {
        this.alarmedObjectDao = alarmedObjectDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<AlarmedObject> list() {
        log.info("list() alarmDao=" + alarmedObjectDao);
        return alarmedObjectDao.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    @SuppressWarnings("unchecked")
    public void save(AlarmedObject item) {
        log.info("save(): " + item);
        alarmedObjectDao.save(item);
    }
}
