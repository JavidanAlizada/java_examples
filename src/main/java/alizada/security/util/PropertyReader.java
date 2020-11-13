package alizada.security.util;

import alizada.security.property_constant.PropertyFileName;
import alizada.security.property_constant.PropertyKeyValue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static String readValueFromProperty(Class<?> cls, PropertyFileName propFile, PropertyKeyValue propKey,
                                               Properties properties) {
        try {
            InputStream inputStream = cls.getClassLoader().getResourceAsStream(propFile.getValue());
            properties.load(inputStream);
            return properties.getProperty(propKey.getValue());
        } catch (IOException exception) {
            exception.printStackTrace();
            return exception.getMessage();
        }
    }
}
