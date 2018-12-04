package by.pvt.dao;

import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;

public class DaoImpl<T> {

    private Class<T> persistentClass;

    public DaoImpl(Class<T> type) {
        this.persistentClass = type;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public T saveOrUpdate(T t) {
        Session session = HibernateUtil.getInstance().getSession();
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
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.getTransaction();
        T t = null;
        try {
            t = (T) session.load(getPersistentClass(), id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        if (t == null)
            throw new IllegalArgumentException("Persistance " +
                    "instance doesn`t exist");
        return t;
    }

    @Nullable
    public T find(Serializable id) {
        Session session = HibernateUtil.getInstance().getSession();
        Transaction transaction = session.getTransaction();
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
}
