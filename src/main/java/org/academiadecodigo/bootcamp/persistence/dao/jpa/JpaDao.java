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

    public JpaDao(JpaSessionManager sm, Class<T> tClass) {
        this.sm = sm;
        this.tClass = tClass;
    }

    @Override
    public T saveOrUpdate(T t) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.merge(t);

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public void delete(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            em.remove(em.find(tClass, id));

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public T findById(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.find(tClass, id);

        } catch (PersistenceException ex) {

            throw new TransactionException(ex);
        }
    }

    @Override
    public List<T> findAll() {

        try {

            EntityManager em = sm.getCurrentSession();

            return em.createQuery("from " + tClass.getName()).getResultList();

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    public Integer count() {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.createQuery("SELECT COUNT(user) FROM User user", Integer.class).getSingleResult();

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }
}
