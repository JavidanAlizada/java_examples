package alizada.security.util;

import alizada.security.entity.User;
import alizada.security.property_constant.PropertyKeyValue;
import alizada.security.response.Message;
import alizada.security.response.Response;
import alizada.security.response.Status;
import alizada.security.response.SysMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    protected void writeAllToFile(User user) {
        try {
            UsersToJsonWriter usersToJsonWriter = new UsersToJsonWriter();
            usersToJsonWriter.addUser(user);
            usersToJsonWriter.writeFile();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }



    protected Response<String> createFolder() {
        String folderKey = new PojoJsonHandler().routeToPropertyReader(PropertyKeyValue.FOLDER);
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
}
