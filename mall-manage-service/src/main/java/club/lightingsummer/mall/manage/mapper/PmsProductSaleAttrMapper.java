package club.lightingsummer.mall.manage.mapper;

import club.lightingsummer.mall.api.bean.PmsProductSaleAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author light
 * @date 2019/11/21 0019 16:20
 */
public interface PmsProductSaleAttrMapper extends Mapper<PmsProductSaleAttr> {

    /**
     * description: 根据spuId和skuId查询属性信息
     *
     * @param spuId spuId
     * @param skuId skuId
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsProductSaleAttr>
     */
    List<PmsProductSaleAttr> selectSpuSaleAttrListCheckBySku(@Param("spuId") String spuId
            , @Param("skuId") String skuId);
}
