package alizada.security;

import alizada.security.entity.Role;
import alizada.security.entity.User;
import alizada.security.service.UserService;
import alizada.security.util.PojoJsonHandler;
import alizada.security.util.UsersToJsonWriter;

public class SecurityManagerTest {

    public static void main(String[] args) {
        UserService service = new UserService(new UsersToJsonWriter(), new PojoJsonHandler());
        User user = new User();
        user.setFullName("Javidan Alizada");
        user.setRole(Role.ADMIN);
        System.out.println("Created User: \n" + service.createUser(user));
        System.out.println();
        System.out.println("UserByFullName : \n" + service.getUserByFullName(user.getFullName()));
        System.out.println("All users" + service.getUsers());
    }

    public void registerSecurityManager(SecurityManager securityManager) {
        try {
            System.setSecurityManager(securityManager);
        } catch (SecurityException securityException) {
            securityException.printStackTrace();
        }
    }

//    public void checkSecurityManager() {
//        try {
//            DataInputStream fis = new DataInputStream(new FileInputStream("inputtext.txt"));
//            DataOutputStream fos = new DataOutputStream(new FileOutputStream("outputtext.txt"));
//            String inputString;
//            while ((inputString = fis.readLine()) != null) {
//                fos.writeBytes(inputString);
//                fos.writeByte('\n');
//            }
//            fis.close();
//            fos.close();
//        } catch (IOException ioe) {
//            System.err.println("I/O failed for SecurityManagerTest.");
//        }
//    }
}
