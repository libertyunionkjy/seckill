package xyz.jyke.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.jyke.seckill.pojo.Order;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.vo.GoodsVo;
import xyz.jyke.seckill.vo.OrderDetailVo;

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

    /**
     * 订单详情
     * @param orderId * @return
     */
    OrderDetailVo detail(Long orderId);

    String createPath(User user, Long goodsId);

    /**
     * 校验秒杀地址
     *
     * @param user
     * @param goodsId
     * @param path
     * @return
     */
    boolean checkPath(User user, Long goodsId, String path);

    /**
     * 校验验证码
     * @param user
     * @param goodsId
     * @param captcha
     * @return
     */
    boolean checkCaptcha(User user, Long goodsId, String captcha);
}
