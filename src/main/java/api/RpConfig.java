package api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RpConfig {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = RpConfig.class.getClassLoader().getResourceAsStream("rp.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить rp.properties", e);
        }
    }

    public static String getKey(String key) {
        return props.getProperty(key);
    }

    public static String getURL(String baseURL) {
        return props.getProperty(baseURL);
    }

    public static String getLogin(String login) {
        return props.getProperty(login);
    }

    public static String getPassword(String password) {
        return props.getProperty(password);
    }
}
