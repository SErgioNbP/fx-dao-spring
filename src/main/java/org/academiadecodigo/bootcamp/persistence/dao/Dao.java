package org.academiadecodigo.bootcamp.persistence.dao;

import java.util.List;

/**
 * Created by codecadet on 05/12/2017.
 */
public interface Dao<T> {

    T findById(Integer id);

    List<T> findAll();

    T saveOrUpdate(T t);

    void delete(Integer id);

    Integer count();
}
