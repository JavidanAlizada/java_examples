package alizada.security.service;

import alizada.security.dao.UserDao;
import alizada.security.entity.User;
import alizada.security.response.Response;
import alizada.security.util.PojoJsonHandler;
import alizada.security.util.UsersToJsonWriter;

import java.util.List;

public class UserService implements UserDao {

    private UsersToJsonWriter usersToJsonWriter;
    private PojoJsonHandler handler;

    public UserService(UsersToJsonWriter usersToJsonWriter, PojoJsonHandler handler) {
        this.usersToJsonWriter = usersToJsonWriter;
        this.handler = handler;
    }

    @Override
    public User createUser(User user) {
        Response<User> response = handler.writeUserToJson(user);
        System.out.println("Response object for writingUserToJson:" + response);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return usersToJsonWriter.readUsers();
    }

    @Override
    public User getUserByFullName(String fullName) {
        for (User user : getUsers()) {
            System.out.println("User object is in Response : " +handler.readUserObjectFromJson());
            return user.getFullName().equals(fullName) ? user : null;
        }
        return null;
    }
}
