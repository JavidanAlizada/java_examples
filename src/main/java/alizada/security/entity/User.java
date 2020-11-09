package alizada.security.entity;

public class User {

    private String fullName;
    private Role role;

    public User() {
    }

    public User(String fullName, Role role) {
        this.fullName = fullName;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", role=" + role +
                '}';
    }
}
