package org.academiadecodigo.bootcamp.persistence;

public interface TransactionManager {

    void beginRead();

    void beginWrite();

    void commit();

    void rollback();

}


