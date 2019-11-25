package club.lightingsummer.mall.manage.service.impl;

import club.lightingsummer.mall.api.bean.PmsSkuAttrValue;
import club.lightingsummer.mall.api.bean.PmsSkuImage;
import club.lightingsummer.mall.api.bean.PmsSkuInfo;
import club.lightingsummer.mall.api.bean.PmsSkuSaleAttrValue;
import club.lightingsummer.mall.api.service.SkuService;
import club.lightingsummer.mall.manage.mapper.PmsSkuAttrValueMapper;
import club.lightingsummer.mall.manage.mapper.PmsSkuImageMapper;
import club.lightingsummer.mall.manage.mapper.PmsSkuInfoMapper;
import club.lightingsummer.mall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author light
 * @date 2019/11/21 0021 16:34
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        List<PmsSkuImage> pmsSkuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : pmsSkuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }

        List<PmsSkuAttrValue> pmsSkuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : pmsSkuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : pmsSkuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }
    }

    @Override
    public PmsSkuInfo getSkuInfoById(String skuId) {
        // 查询sku基本信息
        Example infoExample = new Example(PmsSkuInfo.class);
        infoExample.createCriteria().andEqualTo("id",skuId);
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoMapper.selectOneByExample(infoExample);
        // 查询图片信息
        Example imgExample = new Example(PmsSkuImage.class);
        imgExample.createCriteria().andEqualTo("skuId",skuId);
        List<PmsSkuImage> pmsSkuImageList = pmsSkuImageMapper.selectByExample(imgExample);
        pmsSkuInfo.setSkuImageList(pmsSkuImageList);
        return pmsSkuInfo;
    }

    @Override
    public List<PmsSkuInfo> getSkuAttrListBySpuId(String spuId) {
        return pmsSkuInfoMapper.selectSkuAttrListBySpuId(spuId);
    }
}
