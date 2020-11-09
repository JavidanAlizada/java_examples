package alizada.security.auth;

public enum PropertyKeyValue {

    PASSWORD("system.user.password"), FOLDER("system.folder.path"), FILE("system.file.path");

    private String value;

    PropertyKeyValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
