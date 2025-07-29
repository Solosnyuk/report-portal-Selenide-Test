package api.pojos;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class CreateLaunchRequest {
    private String startTime;
    private String name;
    private String description;
    private List<Attribute> attributes;
    private String uuid;
    private String mode;
    private boolean rerun;
    private String rerunOf;

    public static class Attribute {
        private String key;
        private String value;
        private boolean system;

        public Attribute() {}

        public Attribute(String key, String value, boolean system) {
            this.key = key;
            this.value = value;
            this.system = system;
        }

        public String getKey() {
            return key;
        }
        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }

        public boolean isSystem() {
            return system;
        }
        public void setSystem(boolean system) {
            this.system = system;
        }
    }

    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isRerun() {
        return rerun;
    }
    public void setRerun(boolean rerun) {
        this.rerun = rerun;
    }

    public String getRerunOf() {
        return rerunOf;
    }
    public void setRerunOf(String rerunOf) {
        this.rerunOf = rerunOf;
    }

    public static CreateLaunchRequest defaultLaunch(String name) {
        CreateLaunchRequest launch = new CreateLaunchRequest();
        launch.setStartTime(OffsetDateTime.now().toString());
        launch.setName(name);
        launch.setDescription("Triggered via RestAssured");
        launch.setAttributes(List.of(new Attribute("env", "test", false)));
        launch.setUuid(UUID.randomUUID().toString());
        launch.setMode("DEFAULT");
        launch.setRerun(false);
        launch.setRerunOf("");
        return launch;
    }
}
