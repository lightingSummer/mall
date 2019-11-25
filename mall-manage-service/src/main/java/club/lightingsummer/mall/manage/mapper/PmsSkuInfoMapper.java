package club.lightingsummer.mall.manage.mapper;

import club.lightingsummer.mall.api.bean.PmsSkuInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author light
 * @date 2019/11/21 0019 16:20
 */
public interface PmsSkuInfoMapper extends Mapper<PmsSkuInfo> {
    /**
     * description: 通过spuId获取属性和skuId的hash表
     *
     * @param spuId spuId
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsSkuInfo>
     */
    List<PmsSkuInfo> selectSkuAttrListBySpuId(@Param("spuId") String spuId);
}
