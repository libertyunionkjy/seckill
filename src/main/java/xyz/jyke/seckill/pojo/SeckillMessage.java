package xyz.jyke.seckill.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    /**
    * 秒杀消息对象
    * @author junyu
    * @since 1.0.0
    */
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public class SeckillMessage {
     private User user;
     private Long goodsId;
  }
