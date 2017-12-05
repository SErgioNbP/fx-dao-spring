package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistence.dao.UserDao;
import org.academiadecodigo.bootcamp.persistence.TransactionException;
import org.academiadecodigo.bootcamp.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.utils.Security;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private TransactionManager tx;

    public UserServiceImpl(UserDao userDao, TransactionManager tx) {
        this.userDao = userDao;
        this.tx = tx;
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
    @Override
    public boolean authenticate(String username, String password) {

        boolean result = false;

        try {

            tx.beginRead();

            User user = userDao.findByUsername(username);
            result = (user != null && user.getPassword().equals(Security.getHash(password)));

            tx.commit();

        } catch (TransactionException ex) {

            System.out.println("Error authenticating: " + ex.getMessage());
            tx.rollback();

        }

        return result;

    }

    /**
     * Adds a new user
     *
     * @param user the new user to add
     */
    @Override
    public void addUser(User user) {

        try {

            tx.beginWrite();

            if (userDao.findByUsername(user.getUsername()) == null) {
                userDao.saveOrUpdate(user);
            }

            tx.commit();

        } catch (TransactionException ex) {

            tx.rollback();

        }

    }

    /**
     * Finds a user by name
     *
     * @param username the user name used to lookup a user
     * @return a new User if found, null otherwise
     */
    @Override
    public User findByName(String username) {

        User user = null;

        try {

            tx.beginRead();

            user = userDao.findByUsername(username);

            tx.commit();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            tx.rollback();

        }

        return user;
    }

    /**
     * Count the number of existing users
     *
     * @return the number of users
     */
    @Override
    public long count() {

        long size = 0;

        try {

            tx.beginRead();

            size = userDao.count();

            tx.commit();

        } catch (TransactionException ex) {

            System.out.println(ex.getMessage());
            tx.rollback();

        }

        return size;

    }
}

