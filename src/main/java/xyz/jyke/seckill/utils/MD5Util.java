package xyz.jyke.seckill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {
    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    //盐，这个盐是前端需要用到的，前端传过来的数据是加盐MD5后的数据，我们后段也需要同样的盐获取到跟前端一样的数据
    private static final String salt = "1a2b3c4d";


    //输入密码转成后端接收的密码
    public static String inputPassToFormPass(String inputPass) {
        //混淆
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass
                + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }


    //最终我们要调用的方法，后端接收的密码转成数据库的密码
    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    //把明文密码转换成了数据库密码
    public static String inputPassToDBPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("654321"));
        System.out.println(formPassToDBPass("95e3781c521ef993a6cf2d1d45854218", "1a2b3c4d"));
        System.out.println(inputPassToDBPass("654321", "1a2b3c4d"));
    }
}
