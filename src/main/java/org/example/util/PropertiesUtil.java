package org.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties prop = new Properties();

    static {
        try {
            InputStream inputStream =
                    PropertiesUtil.class.getClassLoader().getResourceAsStream("resources.properties");
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String name) {
        return prop.getProperty(name);
    }
}
