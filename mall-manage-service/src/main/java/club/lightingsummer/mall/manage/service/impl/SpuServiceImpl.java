package club.lightingsummer.mall.manage.service.impl;

import club.lightingsummer.mall.api.bean.PmsProductImage;
import club.lightingsummer.mall.api.bean.PmsProductInfo;
import club.lightingsummer.mall.api.bean.PmsProductSaleAttr;
import club.lightingsummer.mall.api.bean.PmsProductSaleAttrValue;
import club.lightingsummer.mall.api.service.SpuService;
import club.lightingsummer.mall.manage.mapper.PmsProductImageMapper;
import club.lightingsummer.mall.manage.mapper.PmsProductInfoMapper;
import club.lightingsummer.mall.manage.mapper.PmsProductSaleAttrMapper;
import club.lightingsummer.mall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author light
 * @date 2019/11/21 0021 13:51
 */
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        Example example = new Example(PmsProductInfo.class);
        example.createCriteria().andEqualTo("catalog3Id", catalog3Id);
        return pmsProductInfoMapper.selectByExample(example);
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {

    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        Example attrExample = new Example(PmsProductSaleAttr.class);
        attrExample.createCriteria().andEqualTo("productId", spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrList = pmsProductSaleAttrMapper.selectByExample(attrExample);
        for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrList) {
            Example valueExample = new Example(PmsProductSaleAttrValue.class);
            valueExample.createCriteria().andEqualTo("productId", spuId)
                    .andEqualTo("saleAttrId", pmsProductSaleAttr.getSaleAttrId());
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValueList = pmsProductSaleAttrValueMapper.selectByExample(valueExample);
            pmsProductSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValueList);
        }
        return pmsProductSaleAttrList;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        Example example = new Example(PmsProductImage.class);
        example.createCriteria().andEqualTo("productId", spuId);
        return pmsProductImageMapper.selectByExample(example);
    }

    @Override
    public List<PmsProductSaleAttr> getSpuSaleAttrListCheckBySku(String spuId, String skuId) {
        return pmsProductSaleAttrMapper.selectSpuSaleAttrListCheckBySku(spuId,skuId);
    }
}
