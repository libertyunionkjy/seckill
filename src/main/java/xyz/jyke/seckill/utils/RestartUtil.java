package xyz.jyke.seckill.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Set;

/**
 * @className: RestartUtil
 * @description: TODO 类描述
 * @author: junyu
 * @date: 2021/11/4
 **/
@Component
public class RestartUtil {
    @Autowired
    private RedisTemplate redisTemplate;

    public void restartSecTest() throws Exception {
        Connection conn = getConn();
        String sql = "truncate table t_seckill_order";
        String sql2 = "truncate table t_order";
        String sql3 = "update t_seckill_goods set stock_count = '"+10+"' WHERE id = " +1;
        Statement statement = conn.createStatement();
        statement.execute(sql);
        statement.execute(sql2);
        statement.execute(sql3);
        statement.close();
        conn.close();
        Set<String> keys = redisTemplate.keys("order:" + "*");
        redisTemplate.delete(keys);
        System.out.println("done!");
    }

    private static Connection getConn() throws Exception {
        String url = "jdbc:mysql://localhost:3306/seckill?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "12345678";
        String driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        RestartUtil restartUtil = new RestartUtil();
        restartUtil.restartSecTest();
    }
}
