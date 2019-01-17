package io.swagger.service;


import io.swagger.dao.AffectedServiceDaoImpl;
import io.swagger.model.AffectedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class AffectedServiceServiceImpl extends BaseServiceImpl {

    private static Logger log = Logger.getLogger(AffectedService.class.getName());

    private final AffectedServiceDaoImpl affectedServiceDao;

    @Autowired
    public AffectedServiceServiceImpl(AffectedServiceDaoImpl affectedServiceDao) {
        this.affectedServiceDao = affectedServiceDao;
    }

    @Override
    public List list() {
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    @SuppressWarnings("unchecked")
    public List<AffectedService> update(List<AffectedService> items) {
        List<AffectedService> list = new ArrayList<>();
        items.forEach(item -> {
            if (item.getId() == null) {
                affectedServiceDao.save(item);
            }
            list.add(item);
        });
        log.info("save(): " + items);
        return list;
    }
}
