package xyz.jyke.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.jyke.seckill.mapper.OrderMapper;
import xyz.jyke.seckill.pojo.Order;
import xyz.jyke.seckill.pojo.SeckillGoods;
import xyz.jyke.seckill.pojo.SeckillOrder;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.service.IGoodsService;
import xyz.jyke.seckill.service.IOrderService;
import xyz.jyke.seckill.service.ISeckillGoodsService;
import xyz.jyke.seckill.service.ISeckillOrderService;
import xyz.jyke.seckill.vo.GoodsVo;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junyu
 * @since 2021-10-29
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

    @Autowired
    private ISeckillGoodsService seckillGoodsService;
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ISeckillOrderService seckillOrderService;

    @Override
    @Transactional
    public Order seckill(User user, GoodsVo goods) {
    //秒杀商品表减库存
    SeckillGoods seckillGoods = seckillGoodsService.getOne(new QueryWrapper<SeckillGoods>().eq("goods_id", goods.getId())); seckillGoods.setStockCount(seckillGoods.getStockCount()-1); seckillGoodsService.updateById(seckillGoods);
    //生成订单
    Order order = new Order();
    order.setUserId(user.getId()); order.setGoodsId(goods.getId()); order.setDeliveryAddrId(0L); order.setGoodsName(goods.getGoodsName()); order.setGoodsCount(1); order.setGoodsPrice(seckillGoods.getSeckillPrice()); order.setOrderChannel(1);
    order.setStatus(0);
    order.setCreateData(new Date());
    orderMapper.insert(order);
    //生成秒杀订单
    SeckillOrder seckillOrder = new SeckillOrder(); seckillOrder.setOrderId(order.getId()); seckillOrder.setUserId(user.getId()); seckillOrder.setGoodsId(goods.getId()); seckillOrderService.save(seckillOrder);
    return order;
    }
}
