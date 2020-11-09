package alizada.security;

import alizada.security.auth.PropertyKeyValue;
import alizada.security.entity.Role;
import alizada.security.entity.User;

public class UserRoleSecurityManager extends SecurityManager {

    private String sysPassword;

    private User user;

    public UserRoleSecurityManager(String sysPassword, User user) {
        this.sysPassword = sysPassword;
        this.user = user;
    }

    public String getSysPassword() {
        return sysPassword;
    }

    public User getUser() {
        return user;
    }

    private boolean isAccessible() {
        return sysPassword.equals(PropertyKeyValue.PASSWORD.getValue()) &&
                (user.getRole() == Role.ADMIN || user.getRole() == Role.MANAGER);
    }

    @Override
    public void checkWrite(String s) {
        if (!isAccessible())
            throw new SecurityException("no permission to write");
    }

    @Override
    public void checkRead(String s) {
        if (!isAccessible())
            throw new SecurityException("no permission to read");
    }
}
