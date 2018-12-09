package by.pvt.dao;

import by.pvt.pojo.Person;
import by.pvt.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class DaoImpl<T> {

    private Class<T> persistentClass;

    public static boolean isTestInsrance;


    public DaoImpl(Class<T> type) {
        this.persistentClass = type;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    private Session getSession(){
        if (isTestInsrance)
            return HibernateUtil.getInstance().getTestSession();
        else
            return HibernateUtil.getInstance().getSession();
    }

    public T saveOrUpdate(T t) {
        Session session = getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return t;
    }

    @NotNull
    public T load(Serializable id) {
        if (id == null)
            throw new IllegalArgumentException("Persistant " +
                    "instance id must not be null");
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        T t = null;
        try {
            t = (T) session.load(getPersistentClass(), id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        if (t == null)
            throw new IllegalStateException("Persistance " +
                    "instance doesn`t exist");
        return t;
    }

    @Nullable
    public T find(Serializable id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        T t = null;
        try {
            t = (T) session.get(getPersistentClass(), id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return t;
    }

    public void updateName(Serializable id, String name) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Person person = (Person) session.get(getPersistentClass(), id);
            person.setName(name);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(Serializable id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            T t = session.get(getPersistentClass(), id);
            session.delete(t);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }
}
