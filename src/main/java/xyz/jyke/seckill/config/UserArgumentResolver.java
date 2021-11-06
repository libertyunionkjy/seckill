package xyz.jyke.seckill.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.service.IUserService;
import xyz.jyke.seckill.utils.CookieUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: UserArgumentResolver
 * @description: User参数校验
 * @author: junyu
 * @date: 2021/10/29
 **/
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private IUserService userService;

    //supportsParameter 方法返回 boolean 值，表示是否启用该解析器
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        Class<?> clazz = methodParameter.getParameterType();
        return clazz == User.class;
    }

    /**
     * resolveArgument 方法表示方法参数的解析过程，就是你把 HTTP 的请求参数转换为方法参数的过程，返回 Object 对象，即参数的转换结果。
     * @return 参数的解析结果
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        /*HttpServletResponse response= nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        String ticket = CookieUtil.getCookieValue(request, "userTicket");
        if (StringUtils.isEmpty(ticket)) {
            return null;
        }
        User user = userService.getByUserTicket(ticket, request, response);
        return user;*/
        return UserContext.getUser();
    }
}
