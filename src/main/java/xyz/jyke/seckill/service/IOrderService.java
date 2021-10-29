package xyz.jyke.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.jyke.seckill.pojo.Order;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junyu
 * @since 2021-10-29
 */
public interface IOrderService extends IService<Order> {

    Order seckill(User user, GoodsVo goods);
}
