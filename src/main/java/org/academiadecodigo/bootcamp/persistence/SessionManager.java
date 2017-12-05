package org.academiadecodigo.bootcamp.persistence;

public interface SessionManager<T> {

    void startSession();

    void stopSession();

    T getCurrentSession();

}

