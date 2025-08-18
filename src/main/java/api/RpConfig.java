package api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RpConfig {
    private static final Properties props = new Properties();
    private static final RpConfigFields.RpConfigModel CONFIG;

    static {
        try (InputStream input = RpConfig.class.getClassLoader().getResourceAsStream("rp.properties")) {
            if (input == null) {
                throw new RuntimeException("Файл rp.properties не найден в classpath");
            }
            props.load(input);
            CONFIG = new RpConfigFields.RpConfigModel(props);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить rp.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static RpConfigFields.RpConfigModel getConfig() {
        return CONFIG;
    }
}
