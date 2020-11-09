package alizada.security.auth;

public enum PropertyFileName {
    PROPERTY_FILE_NAME("security.properties");

    private String value;

    PropertyFileName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
