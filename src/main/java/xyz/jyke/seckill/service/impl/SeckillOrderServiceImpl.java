package xyz.jyke.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.jyke.seckill.mapper.SeckillOrderMapper;
import xyz.jyke.seckill.pojo.SeckillOrder;
import xyz.jyke.seckill.service.ISeckillOrderService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junyu
 * @since 2021-10-29
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements ISeckillOrderService {

}
