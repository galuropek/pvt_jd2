package by.it.dao;

import by.it.pojos.Person;
import by.it.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;

public class PersonDao {

    public static Person savePerson(Person person){
        Session session = HibernateUtil.getInstance().getSession();
        session.beginTransaction();
        Serializable save = session.save(person);
        session.getTransaction().commit();
        return (Person) save;
    }
}
