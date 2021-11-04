package xyz.jyke.seckill.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.jyke.seckill.mq.MQSender;
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

    @Autowired
    private MQSender mqSender;

    /**
     * 用户信息(测试)
     *
     * @param user
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user) {
        return RespBean.success(user);
    }


    /**
     * 测试发送RabbitMQ消息
     */
    /*
    @RequestMapping("/mq")
    @ResponseBody
    public void mq() {
        mqSender.send("Hello");
    }

    @RequestMapping("/mq/direct01")
    @ResponseBody
    public void mqDirectRed() {
        mqSender.send01("Hello Red");
    }

    @RequestMapping("/mq/direct02")
    @ResponseBody
    public void mqDirectGreen() {
        mqSender.send02("Hello Green");
    }

     */


}
