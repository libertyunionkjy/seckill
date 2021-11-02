package xyz.jyke.seckill.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.vo.RespBean;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhoubin * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 用户信息(测试)
     * @param user
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user) {
        return RespBean.success(user);
    }
}
