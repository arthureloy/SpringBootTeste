package utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SenhaUtils {

    /**
     * gera um hash utilizando bcrypt
     */
    public static String createBCrypt(String password) {
        if (password == null) {
            return password;
        }
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.encode(password);
    }

    public static boolean isValidPassword(String password, String encodedPassword) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.matches(password, encodedPassword);
    }
}
