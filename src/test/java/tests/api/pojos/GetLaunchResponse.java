package tests.api.pojos;

import java.util.List;

public class  GetLaunchResponse {
    private List<LaunchContent> content;
    private PageInfo page;

    // Геттеры и сеттеры
    public List<LaunchContent> getContent() {
        return content;
    }
    public void setContent(List<LaunchContent> content) {
        this.content = content;
    }

    public PageInfo getPage() {
        return page;
    }
    public void setPage(PageInfo page) {
        this.page = page;
    }

    public static class LaunchContent {
        private long id;            // ⭐
        private String uuid;        // ⭐
        private String name;        // ⭐
        private long number;        // ⭐
        private String startTime;   // ⭐
        private String status;      // ⭐
        private List<Attribute> attributes;

        // Геттеры и сеттеры
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }

        public String getUuid() {
            return uuid;
        }
        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public long getNumber() {
            return number;
        }
        public void setNumber(long number) {
            this.number = number;
        }

        public String getStartTime() {
            return startTime;
        }
        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }

        public List<Attribute> getAttributes() {
            return attributes;
        }
        public void setAttributes(List<Attribute> attributes) {
            this.attributes = attributes;
        }

        public static class Attribute {
            private String key;
            private String value; // ⭐

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
        }
    }

    public static class PageInfo {
        private long number;
        private long size;
        private long totalElements;
        private long totalPages;
        private boolean hasNext;

        // Геттеры и сеттеры
        public long getNumber() {
            return number;
        }
        public void setNumber(long number) {
            this.number = number;
        }

        public long getSize() {
            return size;
        }
        public void setSize(long size) {
            this.size = size;
        }

        public long getTotalElements() {
            return totalElements;
        }
        public void setTotalElements(long totalElements) {
            this.totalElements = totalElements;
        }

        public long getTotalPages() {
            return totalPages;
        }
        public void setTotalPages(long totalPages) {
            this.totalPages = totalPages;
        }

        public boolean isHasNext() {
            return hasNext;
        }
        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }
    }
}
