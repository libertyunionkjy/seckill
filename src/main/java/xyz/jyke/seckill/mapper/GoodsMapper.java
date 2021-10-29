package xyz.jyke.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import xyz.jyke.seckill.pojo.Goods;
import xyz.jyke.seckill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junyu
 * @since 2021-10-29
 */
public interface GoodsMapper extends BaseMapper<Goods> {


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
