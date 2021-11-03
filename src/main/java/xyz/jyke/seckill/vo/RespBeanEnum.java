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
    BIND_ERROR(500213,"参数校验异常"),
    //秒杀模块
    EMPTY_STOCK(500500, "库存不足"),
    REPEATE_ERROR(500501,"不能重复秒杀！只能限购一件"),
    //更新密码
    MOBILE_NOT_EXIST(500213, "手机号码不存在"),
    PASSWORD_UPDATE_FAIL(500214, "密码更新失败");

    private final Integer code;
    private final String message;
}
