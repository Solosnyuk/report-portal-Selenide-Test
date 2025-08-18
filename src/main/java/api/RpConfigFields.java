package api;

import java.util.Properties;

public class RpConfigFields {
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
