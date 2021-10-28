package xyz.jyke.seckill.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.jyke.seckill.vo.RespBean;
import xyz.jyke.seckill.vo.RespBeanEnum;

/**
 * @className: GlobalExceptionHandler
 * @description: TODO 类描述
 * @author: junyu
 * @date: 2021/10/26
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {


    //定义了这个Handler可以处理Exception异常
    @ExceptionHandler(Exception.class)
    public RespBean ExceptionHandler(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return RespBean.error(ex.getRespBeanEnum());
        } else if (e instanceof BindException) {//把我们对LoginVo进行参数校验发生的异常进行单独处理
            BindException ex = (BindException) e;
            RespBean respBean = RespBean.error(RespBeanEnum.BIND_ERROR);
            respBean.setMessage("参数校验异常:" +
                    ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
            return respBean;
        }
        return RespBean.error(RespBeanEnum.ERROR);
    }
}
