package xyz.jyke.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.jyke.seckill.pojo.Goods;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @className: GoodsVo
 * @description: 包装我们要在前端显示的商品信息，既要查询商品表，又要查询秒杀商品表
 * @author: junyu
 * @date: 2021/10/29
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo extends Goods {
    private BigDecimal seckillPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
