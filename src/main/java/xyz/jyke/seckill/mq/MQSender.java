package xyz.jyke.seckill.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhoubin
 * @since 1.0.0
 */
@Service
@Slf4j
public class MQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //public void send(Object msg) {
    //    log.info("发送消息:" + msg);
    //    rabbitTemplate.convertAndSend("fanoutExchange", "",msg);
    //}
    //
    //public void send01(Object msg) {
    //    log.info("发送res消息:" + msg);
    //    rabbitTemplate.convertAndSend("directExchange", "queue.red",msg);
    //}
    //public void send02(Object msg) {
    //    log.info("发送green消息:" + msg);
    //    rabbitTemplate.convertAndSend("directExchange", "queue.green",msg);
    //}


    public void sendsecKillMessage(String message) {
        log.info("发送消息:" + message);
        rabbitTemplate.convertAndSend("seckillExchange", "seckill.msg", message);
    }

}