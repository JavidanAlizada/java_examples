package alizada.security.dao;

import alizada.security.entity.User;

import java.util.List;

public interface UserDao {

    User createUser(User user);

    List<User> getUsers();

    User getUserByFullName(String fullName);
}
