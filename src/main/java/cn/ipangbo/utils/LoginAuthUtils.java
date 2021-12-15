package cn.ipangbo.utils;

public class LoginAuthUtils {
    public static boolean check(String uname, String password) {
        if ("admin".equals(uname) && "admin".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
