package org.academiadecodigo.bootcamp.persistence.dao;

import org.academiadecodigo.bootcamp.model.User;

import java.util.List;

public interface UserDao extends Dao<User> {

    User findByUsername(String username);

}

