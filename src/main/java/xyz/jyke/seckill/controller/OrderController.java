package xyz.jyke.seckill.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.service.IOrderService;
import xyz.jyke.seckill.vo.OrderDetailVo;
import xyz.jyke.seckill.vo.RespBean;
import xyz.jyke.seckill.vo.RespBeanEnum;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author junyu
 * @since 2021-10-29
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    /**
     * 订单详情
     *
     * @param user
     * @param orderId * @return
     */
    @RequestMapping("/detail")
    @ResponseBody
    public RespBean detail(User user, Long orderId) {
        if (null == user) {
            return RespBean.error(RespBeanEnum.SESSION_ERROR);
        }
        OrderDetailVo detail = orderService.detail(orderId);
        return RespBean.success(detail);
    }

}
