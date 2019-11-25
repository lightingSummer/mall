package club.lightingsummer.mall.api.service;

import club.lightingsummer.mall.api.bean.PmsSkuInfo;

import java.util.List;

/**
 * @author light
 * @date 2019/11/21 0015 17:04
 */
public interface SkuService {
    /**
     * description: 保存sku信息
     *
     * @param pmsSkuInfo sku信息
     */
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    /**
     * description: 根据skuId查询信息
     *
     * @param skuId skuId
     * @return club.lightingsummer.mall.api.bean.PmsSkuInfo
     */
    PmsSkuInfo getSkuInfoById(String skuId);

    /**
     * description: 通过spuId获取属性和skuId的hash表
     *
     * @param spuId spuId
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsSkuInfo>
     */
    List<PmsSkuInfo> getSkuAttrListBySpuId(String spuId);
}
