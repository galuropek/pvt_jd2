package io.swagger.service;

import io.swagger.dao.BaseDaoImpl;
import io.swagger.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BaseServiceImpl<T> {

    private static Logger log = Logger.getLogger(BaseServiceImpl.class.getName());

    @Autowired
    private BaseDaoImpl<Customer> customerBaseDao;

    public List<T> list() {
        log.info("BaseServiceImpl:" + customerBaseDao);
        return (List<T>) customerBaseDao.find();
    }
}
