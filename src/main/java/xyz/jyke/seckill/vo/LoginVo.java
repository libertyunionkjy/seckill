package xyz.jyke.seckill.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import xyz.jyke.seckill.validator.IsMobile;

import javax.validation.constraints.NotNull;

/**
 * @className: LoginVO
 * @description: TODO 类描述
 * @author: junyu
 * @date: 2021/10/26
 **/
@Data
public class LoginVo {
    @NotNull
    @IsMobile(required = true)
    private String mobile;

    @NotNull
    @Length(min = 32)
    private String password;
}
