package org.academiadecodigo.bootcamp.persistence.dao.jpa;

import org.academiadecodigo.bootcamp.model.Bootcamp;
import org.academiadecodigo.bootcamp.persistence.dao.BootcampDao;
import org.academiadecodigo.bootcamp.persistence.jpa.JpaSessionManager;


public class JpaBootcampDao extends JpaDao<Bootcamp> implements BootcampDao {

    public JpaBootcampDao(JpaSessionManager sm) {
        super(sm, Bootcamp.class);
    }
}




















/*
    private JpaSessionManager sm;

    public JpaBootcampDao(JpaSessionManager sm) {
        this.sm = sm;
    }

    @Override
    public Bootcamp saveOrUpdate(Bootcamp bootcamp) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.merge(bootcamp);

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    public void delete(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            em.remove(em.find(Bootcamp.class, id));

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public Bootcamp findById(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.find(Bootcamp.class, id);

        } catch (PersistenceException ex) {

            throw new TransactionException(ex);
        }
    }

    @Override
    public List<Bootcamp> findAll() {

        try {

            EntityManager em = sm.getCurrentSession();

//            CriteriaQuery<Bootcamp> criteriaQuery = em.getCriteriaBuilder().createQuery(Bootcamp.class);
//            Root<Bootcamp> root = criteriaQuery.from(Bootcamp.class);
//            return em.createQuery(criteriaQuery).getResultList();

            // Using JPQL
            return em.createQuery("select bootcamp from Bootcamp bootcamp", Bootcamp.class).getResultList();


        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    public Integer count() {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.createQuery("SELECT COUNT(bootcamp) FROM Bootcamp bootcamp", Integer.class).getSingleResult();

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }
    */
