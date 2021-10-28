package xyz.jyke.seckill.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.jyke.seckill.vo.RespBeanEnum;

/**
 * @className: GlobalException
 * @description: 异常类
 * @author: junyu
 * @date: 2021/10/26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    private RespBeanEnum respBeanEnum;
}
