package org.academiadecodigo.bootcamp.persistence.jpa;

import org.academiadecodigo.bootcamp.persistence.TransactionManager;

public class JpaTransactionManager implements TransactionManager {

    private JpaSessionManager sm;

    public JpaTransactionManager(JpaSessionManager sm) {
        this.sm = sm;
    }

    public void beginRead() {
        sm.startSession();
    }

    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    public void commit() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().commit();
        }

        sm.stopSession();
    }

    public void rollback() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().rollback();
        }

        sm.stopSession();
    }
}
