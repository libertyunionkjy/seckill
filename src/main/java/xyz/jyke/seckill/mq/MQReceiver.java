package xyz.jyke.seckill.mq;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.jyke.seckill.pojo.SeckillMessage;
import xyz.jyke.seckill.pojo.SeckillOrder;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.service.IGoodsService;
import xyz.jyke.seckill.service.IOrderService;
import xyz.jyke.seckill.utils.JsonUtil;
import xyz.jyke.seckill.vo.GoodsVo;

@Service
@Slf4j
public class MQReceiver {


    //@RabbitListener(queues = "queue")
    //public void receive(String message){
    //    System.out.println("message = " + message);
    //}
    //
    //@RabbitListener(queues = "queue_fanout01")
    //public void receive01(String message){
    //    System.out.println("QUEUE01接收消息 = " + message);
    //}
    //
    //@RabbitListener(queues = "queue_fanout02")
    //public void receive02(String message){
    //    System.out.println("QUEUE02接收消息  = " + message);
    //}
    //
    //@RabbitListener(queues = "queue_direct01")
    //public void receive03(String message){
    //    System.out.println("queue_direct01 接收red消息  = " + message);
    //}
    //
    //@RabbitListener(queues = "queue_direct02")
    //public void receive04(String message){
    //    System.out.println("queue_direct02 接收green消息  = " + message);
    //}

    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IOrderService orderService;

    @RabbitListener(queues = "seckillQueue")
    public void receive(String msg) {
        log.info("QUEUE接受消息:" + msg);
        SeckillMessage message = JsonUtil.jsonStr2Object(msg, SeckillMessage.class);
        Long goodsId = message.getGoodsId();
        User user = message.getUser();
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        //判断库存
        if (goods.getStockCount() < 1) {
            return;
        }
        //判断是否重复抢购
        String seckillOrderJson = (String) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodsId);
        if (!StringUtils.isEmpty(seckillOrderJson)) {
            return;
        }
        orderService.seckill(user, goods);
    }


}