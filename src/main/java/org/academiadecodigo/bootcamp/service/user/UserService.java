package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.service.Service;

/**
 * user service
 */
public interface UserService extends Service {

    /**
     * Authenticates the user using the given username and password
     * @param username the user name
     * @param password the user password
     * @return true if authenticated
     */
    boolean authenticate(String username, String password);

    /**
     * Adds a new user
     * @param user the new user to add
     */
    void addUser(User user);

    /**
     * Finds a user by name
     * @param username the user name used to lookup a user
     * @return a new User if found, null otherwise
     */
    User findByName(String username);

    /**
     * Count the number of existing users
     * @return the number of users
     */
    long count();

}
