package xyz.jyke.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.jyke.seckill.pojo.Order;

/**
   * @author zhoubin
   * @since 1.0.0
   */
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public class OrderDetailVo {
     private Order order;
     private GoodsVo goodsVo;
}