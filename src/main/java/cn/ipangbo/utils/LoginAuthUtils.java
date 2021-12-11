package cn.ipangbo.utils;

public class LoginAuthUtils {
    public static boolean check(String uname, String password) {
        if ("root".equals(uname) && "root".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
