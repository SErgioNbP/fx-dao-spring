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

    private JpaSessionManager sm;

    public JpaUserDao(JpaSessionManager sm) {
        super(sm, User.class);
        this.sm = sm;
    }

    public User findByUsername(String username) {

        try {

            EntityManager em = sm.getCurrentSession();
            TypedQuery<User> query = em.createQuery("SELECT user FROM User user WHERE user.username = :username", User.class);
            query.setParameter("username", username);
            return query.getSingleResult();

        } catch (NoResultException ex) {

            return null;

        } catch (PersistenceException ex) {

            throw new TransactionException(ex);

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
