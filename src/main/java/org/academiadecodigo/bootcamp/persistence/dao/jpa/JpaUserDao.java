package org.academiadecodigo.bootcamp.persistence.dao.jpa;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.jpa.JpaSessionManager;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaUserDao extends JpaDao<User> implements UserDao {

    public JpaUserDao() {
        super(User.class);
    }

    public JpaUserDao(JpaSessionManager jpaSessionManager) {
        super(User.class);
    }

    public User findByUsername(String username) {

        TypedQuery<User> query = em.createQuery("SELECT user FROM User user WHERE user.username = :username", User.class);
        query.setParameter("username", username);
        List<User> u = query.getResultList();

        if (u.isEmpty()) {

            return null;

        } else {

            return u.get(0);
        }
    }
}





















/*
   @Override
    public User saveOrUpdate(User user) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.merge(user);

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    public void delete(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            em.remove(em.find(User.class, id));

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public User findById(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.find(User.class, id);

        } catch (PersistenceException ex) {

            throw new TransactionException(ex);
        }
    }

    @Override
    public List<User> findAll() {

        try {

            EntityManager em = sm.getCurrentSession();

//            CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
//            Root<User> root = criteriaQuery.from(User.class);
//            return em.createQuery(criteriaQuery).getResultList();

            // Using JPQL
            return em.createQuery("select user from User user", User.class).getResultList();


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

 */
