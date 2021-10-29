package xyz.jyke.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.jyke.seckill.pojo.Goods;
import xyz.jyke.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junyu
 * @since 2021-10-29
 */
public interface IGoodsService extends IService<Goods> {

    /**
     * 获取商品列表 * @return */
    List<GoodsVo> findGoodsVo();

    /**
     * 根据商品id获取商品详情
     * @param goodsId
     * @return
     */
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
