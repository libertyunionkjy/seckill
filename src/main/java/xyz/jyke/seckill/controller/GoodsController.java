package xyz.jyke.seckill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;

    /**
     * 跳转到商品列表页面
     *
     * @return
     */
    @RequestMapping("/toList")
    //通过cookie的名称拿到了cookie的值
    public String toLogin(Model model, User user) {
        /*//判断ticket是不是空，如果为空代表没登陆
        if (StringUtils.isEmpty(ticket)) {
            return "login";
        }

        //session中根据ticket获取用户
        //User user = (User) session.getAttribute(ticket);

        //去Redis中获取用户信息
        User user = userService.getByUserTicket(ticket, request, response);

        if (null == user) {
            return "login";
        }*/
        //如果都没问题，把用户对象放到Model中去
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "goodsList";
    }
}