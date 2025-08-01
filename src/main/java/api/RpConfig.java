package api;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class RpConfig {
    private static final Properties props = new Properties();
    private static final RpConfigModel CONFIG;

    static {
        try (InputStream input = RpConfig.class.getClassLoader().getResourceAsStream("rp.properties")) {
            props.load(input);
            CONFIG = new RpConfigModel(props);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось загрузить rp.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static RpConfigModel getConfig() {
        return CONFIG;
    }

    public static class RpConfigModel {
        private final String endpoint;
        private final String apiKey;
        private final String projectName;
        private final String login;
        private final String password;
        private final String launch;

        public RpConfigModel(Properties props) {
            this.endpoint = props.getProperty("rp.endpoint");
            this.apiKey = props.getProperty("rp.api.key");
            this.projectName = props.getProperty("rp.project");
            this.login = props.getProperty("rp.login");
            this.password = props.getProperty("rp.password");
            this.launch = props.getProperty("rp.launch");
            
            validateRequiredFields();
        }

        private void validateRequiredFields() {
            if (endpoint == null || apiKey == null || projectName == null ||
                    login == null || password == null || launch == null) {
                throw new IllegalStateException("В конфигурации отсутствуют обязательные поля");
            }
        }

        public String getEndpoint() {
            return endpoint;
        }

        public String getApiKey() {
            return apiKey;
        }

        public String getProjectName() {
            return projectName;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public String getLaunch() {
            return launch;
        }
    }
}