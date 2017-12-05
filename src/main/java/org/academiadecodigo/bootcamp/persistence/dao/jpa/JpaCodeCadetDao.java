package org.academiadecodigo.bootcamp.persistence.dao.jpa;

import org.academiadecodigo.bootcamp.model.CodeCadet;
import org.academiadecodigo.bootcamp.persistence.dao.CodeCadetDao;
import org.academiadecodigo.bootcamp.persistence.jpa.JpaSessionManager;

public class JpaCodeCadetDao extends JpaDao<CodeCadet> implements CodeCadetDao {

    public JpaCodeCadetDao(JpaSessionManager sm) {
        super(sm, CodeCadet.class);
    }
}
















/*
    private JpaSessionManager sm;

    public JpaCodeCadetDao(JpaSessionManager sm) {
        this.sm = sm;
    }

    @Override
    public CodeCadet saveOrUpdate(CodeCadet codeCadet) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.merge(codeCadet);

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    public void delete(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            em.remove(em.find(CodeCadet.class, id));

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    @Override
    public CodeCadet findById(Integer id) {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.find(CodeCadet.class, id);

        } catch (PersistenceException ex) {

            throw new TransactionException(ex);
        }
    }

    @Override
    public List<CodeCadet> findAll() {

        try {

            EntityManager em = sm.getCurrentSession();

//            CriteriaQuery<CodeCadet> criteriaQuery = em.getCriteriaBuilder().createQuery(CodeCadet.class);
//            Root<CodeCadet> root = criteriaQuery.from(CodeCadet.class);
//            return em.createQuery(criteriaQuery).getResultList();

            // Using JPQL
            return em.createQuery("select codeCadet from CodeCadet codeCadet", CodeCadet.class).getResultList();


        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }

    public Integer count() {

        try {

            EntityManager em = sm.getCurrentSession();
            return em.createQuery("SELECT COUNT(codeCadet) FROM CodeCadet codeCadet", Integer.class).getSingleResult();

        } catch (PersistenceException ex) {
            throw new TransactionException(ex);
        }
    }
*/
