package xyz.jyke.seckill.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.jyke.seckill.service.IUserService;
import xyz.jyke.seckill.vo.LoginVo;
import xyz.jyke.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {
    @Autowired
    private IUserService userService;
    /**
     * 跳转登录页 *
     * @return */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登录
     * 返回的是Bean
     * @return */
    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        log.info(loginVo.toString());
        return userService.login(loginVo,request,response);
    }

}
