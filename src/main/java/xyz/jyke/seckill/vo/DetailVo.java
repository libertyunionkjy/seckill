package xyz.jyke.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.jyke.seckill.pojo.User;

/**
   * @author zhoubin
   * @since 1.0.0
   */
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public class DetailVo {
     private User user;
     private GoodsVo goodsVo;
     private int secKillStatus;
     private int remainSeconds;
   }