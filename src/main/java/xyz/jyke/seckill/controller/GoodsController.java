package xyz.jyke.seckill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.service.IGoodsService;
import xyz.jyke.seckill.service.IUserService;
import xyz.jyke.seckill.vo.GoodsVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodsService goodsService;

    /**
     * 跳转到商品列表页面
     * windows优化前：800
     * linux优化前：200
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
        //if (user == null) {
        //    return "login";
        //}
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     * 跳转商品详情页
     *
     * @param model   * @param user
     * @param goodsId * @return
     */
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, User user, @PathVariable Long goodsId) {
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);
        Date startDate = goods.getStartDate();
        Date endDate = goods.getEndDate();
        Date nowDate = new Date();
        //秒杀状态
        int secKillStatus = 0;
        //剩余开始时间
        int remainSeconds = 0;
        //秒杀还未开始
        if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime() - nowDate.getTime()) / 1000);
        // 秒杀已结束
        } else if (nowDate.after(endDate)) {
            //秒杀已经结束
            secKillStatus = 2;
            remainSeconds = -1;
            // 秒杀中
        } else {
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("secKillStatus", secKillStatus);
        model.addAttribute("remainSeconds", remainSeconds);
        return "goodsDetail";
    }
}