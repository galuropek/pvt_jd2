package by.carrental.project.dao.impl;

import by.carrental.project.dao.UserDao;
import by.carrental.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    private static Logger log = Logger.getLogger(UserDaoImpl.class.getName());

    @Autowired
    public UserDaoImpl() {
        super(User.class);
    }
}
