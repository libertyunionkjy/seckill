package xyz.jyke.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.jyke.seckill.pojo.SeckillOrder;
import xyz.jyke.seckill.pojo.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junyu
 * @since 2021-10-29
 */
public interface ISeckillOrderService extends IService<SeckillOrder> {

    /**
     * 获取秒杀结果
     * @param user
     * @param goodsId
     * @return
     */
    Long getResult(User user, Long goodsId);
}
