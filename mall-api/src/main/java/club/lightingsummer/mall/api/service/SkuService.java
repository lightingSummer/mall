package club.lightingsummer.mall.api.service;

import club.lightingsummer.mall.api.bean.PmsSkuInfo;

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
}
