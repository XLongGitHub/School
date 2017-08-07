package dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    T get(Class<T> entity, Serializable id);

    Serializable save(T entity);

    void update(T entity);

    void delete(T entity);

    void delete(Class<T> entity, Serializable id);

    List<T> findAll(Class<T> entity);

}
