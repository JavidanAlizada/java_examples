package alizada.security.util;

import alizada.security.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersToJsonWriter {

    private List<User> users = readUsers();

    public List<User> readUsers() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<User> users = objectMapper.readValue(new File("./ids/users.json"),
                    new TypeReference<List<User>>() {
                    });
            return users;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void writeFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("./ids/users.json"), users);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
