package xyz.jyke.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.jyke.seckill.mapper.GoodsMapper;
import xyz.jyke.seckill.pojo.Goods;
import xyz.jyke.seckill.service.IGoodsService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junyu
 * @since 2021-10-29
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

}
