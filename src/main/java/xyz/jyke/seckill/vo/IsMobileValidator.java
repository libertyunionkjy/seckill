package xyz.jyke.seckill.vo;

import org.springframework.util.StringUtils;
import xyz.jyke.seckill.utils.ValidatorUtil;
import xyz.jyke.seckill.validator.IsMobile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @className: IsMobileValidator
 * @description: IsMobile注解的实现
 * @author: junyu
 * @date: 2021/10/26
 **/
public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    //初始化方法
    @Override
    public void initialize(IsMobile constraintAnnotation) {
        //这里拿到的是IsMobile中的required值，代表Mobile是否是必填
        required = constraintAnnotation.required();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (required) {
            return ValidatorUtil.isMobile(value);
        } else {
            if (StringUtils.isEmpty(value)) {
                return true;
            } else {//如果是非必填项但是value有值，还是要验证这个值是否符合要求
                return ValidatorUtil.isMobile(value);
            }
        }
    }
}
