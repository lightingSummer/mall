package club.lightingsummer.mall.api.service;

import club.lightingsummer.mall.api.bean.PmsProductImage;
import club.lightingsummer.mall.api.bean.PmsProductInfo;
import club.lightingsummer.mall.api.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * @author light
 * @date 2019/11/21 0021 13:30
 */
public interface SpuService {
    /**
     * description: 根据catalog3Id获取spu商品
     *
     * @param catalog3Id 三级分类id
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsProductInfo>
     */
    List<PmsProductInfo> spuList(String catalog3Id);

    /**
     * description: 保存spu商品
     *
     * @param pmsProductInfo product信息
     */
    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    /**
     * description: 查询卖点信息
     *
     * @param spuId spuId
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsProductSaleAttr>
     */
    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    /**
     * description: 根据spuId获取图片url
     *
     * @param  spuId spuId
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsProductImage>
     */
    List<PmsProductImage> spuImageList(String spuId);
}
