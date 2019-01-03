package io.swagger.service;

import io.swagger.dao.CustomerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CustomerServiceImpl<T> extends BaseServiceImpl {

    private static Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

    @Autowired
    private CustomerDaoImpl<T> customerDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> list() {
        log.info("customerDao: " + customerDao);
        return customerDao.find();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public void save(T item) {
        log.info("save(): " + item);
        customerDao.save(item);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, value = "txManager")
    public void create(List<T> items) {
        log.info("create(): " + items);
        for (T item : items) {
            saveOne(item);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOne(T item){
        customerDao.save(item);
    }
}
