package xyz.jyke.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.jyke.seckill.mapper.OrderMapper;
import xyz.jyke.seckill.pojo.Order;
import xyz.jyke.seckill.service.IOrderService;

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

}
