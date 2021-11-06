package xyz.jyke.seckill.config;

import xyz.jyke.seckill.pojo.User;

/**
 *
 * 用来在同一个线程的上下文保存用户信息，拦截器获取到用户后给参数解析器
 *
 */
public class UserContext {
    private static ThreadLocal<User> userHolder = new ThreadLocal<>();

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static User getUser() {
        return userHolder.get();
    }
}
