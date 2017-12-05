package org.academiadecodigo.bootcamp.service.user;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.utils.Security;

import java.util.HashMap;
import java.util.Map;

/**
 * An in-memory mock user service backed by a HashMap
 */
public class MockUserService implements UserService {

    /** The container of users */
    private Map<String, User> users;

    public MockUserService() {
        users = new HashMap<>();
    }

    public MockUserService(Map<String, User> users) {

        this.users = users;
    }

    @Override
    public String getServiceName() {
        return UserService.class.getSimpleName();
    }

    /**
     * @see UserService#authenticate(String, String)
     */
    @Override
    public boolean authenticate(String username, String password) {

        return users.containsKey(username) && (users.get(username)).getPassword().equals(Security.getHash(password));

    }

    /**
     * @see UserService#addUser(User)
     */
    @Override
    public void addUser(User user) {
        if (!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);
        }
    }

    /**
     * @see UserService#findByName(String)
     */
    @Override
    public User findByName(String username) {
       return users.get(username);
    }

    /**
     * @see UserService#count()
     */
    @Override
    public long count() {
        return users.size();
    }


}
