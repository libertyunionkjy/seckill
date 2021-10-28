package xyz.jyke.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @className: RespBeanEnum
 * @description: 公共返回对象枚举
 * @author: junyu
 * @date: 2021/10/26
 **/
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //通用状态码
    SUCCESS(200,"success"),
    ERROR(500,"服务端异常"),
    //登录模块5002xx
    SESSION_ERROR(500212,"session不存在或者已经失效"),
    LOGINVO_ERROR(500210,"用户名或者密码错误"),
    MOBILE_ERROR(500211,"手机号码格式错误"),
    BIND_ERROR(500213,"参数校验异常");

    private final Integer code;
    private final String message;
}
