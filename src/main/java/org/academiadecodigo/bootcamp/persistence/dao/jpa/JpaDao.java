package org.academiadecodigo.bootcamp.persistence.dao.jpa;

import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.dao.Dao;
import org.academiadecodigo.bootcamp.persistence.jpa.JpaSessionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by codecadet on 05/12/2017.
 */
public abstract class JpaDao<T> implements Dao<T> {

    @PersistenceContext
    protected EntityManager em;
    //private JpaSessionManager sm;

    private Class<T> tClass;

    public JpaDao(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public T saveOrUpdate(T t) {

        return em.merge(t);
    }

    @Override
    public void delete(Integer id) {

        em.remove(em.find(tClass, id));
    }

    @Override
    public T findById(Integer id) {

        return em.find(tClass, id);
    }

    @Override
    public List<T> findAll() {

        return em.createQuery("from " + tClass.getName()).getResultList();
    }

    public Integer count() {

        return em.createQuery("SELECT COUNT(user) FROM User user", Integer.class).getSingleResult();
    }
}
