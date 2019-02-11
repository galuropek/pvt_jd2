package by.carrental.project.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {

    List<T> getAll();

    T get(Serializable id);

    void save(T item);

    void update(T item);

    void delete(T item);

}
