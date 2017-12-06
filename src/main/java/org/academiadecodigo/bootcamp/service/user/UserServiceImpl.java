package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.utils.Security;
import org.springframework.transaction.annotation.Transactional;


public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String getServiceName() {
        return UserService.class.getSimpleName();
    }

    /**
     * Authenticates the user using the given username and password
     *
     * @param username the user name
     * @param password the user password
     * @return true if authenticated
     */
    @Transactional
    @Override
    public boolean authenticate(String username, String password) {

        boolean result = false;

        User user = userDao.findByUsername(username);

        result = (user != null && user.getPassword().equals(Security.getHash(password)));

        return result;
    }

    /**
     * Adds a new user
     *
     * @param user the new user to add
     */
    @Transactional
    @Override
    public void addUser(User user) {

        if (userDao.findByUsername(user.getUsername()) == null) {

            userDao.saveOrUpdate(user);
        }
    }

    /**
     * Finds a user by name
     *
     * @param username the user name used to lookup a user
     * @return a new User if found, null otherwise
     */
    @Transactional
    @Override
    public User findByName(String username) {

        User user = null;

        user = userDao.findByUsername(username);

        return user;
    }

    /**
     * Count the number of existing users
     *
     * @return the number of users
     */
    @Transactional
    @Override
    public long count() {

        long size = 0;

        size = userDao.count();

        return size;
    }
}

