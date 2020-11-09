package alizada.security.util;

import alizada.security.auth.PropertyFileName;
import alizada.security.auth.PropertyKeyValue;
import alizada.security.entity.Role;
import alizada.security.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import alizada.security.response.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Properties;

public class PojoJsonHandler {

    private final Properties properties = new Properties();

    private String routeToPropertyReader(PropertyKeyValue key) {
        return PropertyReader.readValueFromProperty(PojoJsonHandler.class, PropertyFileName.PROPERTY_FILE_NAME,
                key, properties);
    }

    private void writeAllToFile(User user) {
        try {
            UsersToJsonWriter usersToJsonWriter = new UsersToJsonWriter();
            usersToJsonWriter.addUser(user);
            usersToJsonWriter.writeFile();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private Response<String> createFolder() {
        String folderKey = routeToPropertyReader(PropertyKeyValue.FOLDER);
        if (folderKey != null) {
            Path path = Paths.get(folderKey);
            try {
                if (Files.exists(path))
                    return Response.response(folderKey, new Message(SysMessage.FOLDER_EXIST.name()), Status.OK);
                Files.createDirectories(path);
                return Response.response(folderKey, new Message(SysMessage.FOLDER_NON_EXIST.name()), Status.OK);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return Response.response(new Message(ioException.getMessage()), Status.BAD);
            }
        }
        return Response.response(new Message(SysMessage.FOLDER_KEY_NON_EXIST.name()), Status.NULL);
    }

    public <T> Response<User> writeUserToJson(User user) {
        if (createFolder().getStatus() == Status.OK) {
            ObjectMapper objectMapper = new ObjectMapper();
            String fileKey = routeToPropertyReader(PropertyKeyValue.FILE);
            try {
                objectMapper.writeValue(new File(fileKey), user);
                writeAllToFile(user);
                return Response.response(user, new Message(SysMessage.DONE.name()), Status.OK);
            } catch (IOException exception) {
                exception.printStackTrace();
                return Response.response(new Message(exception.getMessage()), Status.BAD);
            }
        }
        return Response.response(new Message(SysMessage.STATUS_NON_OK.name()), Status.NULL);
    }

    public <T> Response<User> readUserObjectFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        String fileKey = routeToPropertyReader(PropertyKeyValue.FILE);
        try {

            User user = objectMapper.readValue(new File(fileKey), User.class);
            return Response.response(user, new Message(SysMessage.DONE.name()), Status.OK);
        } catch (IOException exception) {
            exception.printStackTrace();
            return Response.response(new Message(exception.getMessage()), Status.BAD);
        }
    }

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        User user = new User();
        user.setFullName("Javidan Alizada");
        user.setRole(Role.ADMIN);
        Response<?> response = new PojoJsonHandler().writeUserToJson(user);
        System.out.println(response);
        Response<?> response1 = new PojoJsonHandler().readUserObjectFromJson();
        System.out.println(response1);
        System.out.println(LocalDateTime.now());
    }
}
