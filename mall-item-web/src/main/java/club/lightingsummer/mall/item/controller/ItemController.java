package club.lightingsummer.mall.item.controller;

import club.lightingsummer.mall.api.bean.PmsProductSaleAttr;
import club.lightingsummer.mall.api.bean.PmsSkuInfo;
import club.lightingsummer.mall.api.bean.PmsSkuSaleAttrValue;
import club.lightingsummer.mall.api.service.SkuService;
import club.lightingsummer.mall.api.service.SpuService;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author light
 * @date 2019/11/21 0021 21:40
 */
@Controller
public class ItemController {
    @Reference(interfaceClass = SkuService.class, check = false)
    SkuService skuService;

    @Reference(interfaceClass = SpuService.class, check = false)
    SpuService spuService;

    @RequestMapping(path = "{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap modelMap) {
        // 查询sku基础信息
        PmsSkuInfo pmsSkuInfo = skuService.getSkuInfoById(skuId);
        modelMap.addAttribute("skuInfo", pmsSkuInfo);
        // 查询sku属性的绑定信息
        List<PmsProductSaleAttr> pmsProductSaleAttr = spuService.getSpuSaleAttrListCheckBySku(pmsSkuInfo.getProductId()
                , pmsSkuInfo.getId());
        modelMap.addAttribute("spuSaleAttrListCheckBySku", pmsProductSaleAttr);
        // 查询相关sku的属性绑定信息，并转成hashMap
        List<PmsSkuInfo> relativeSkuAttrInfoList = skuService.getSkuAttrListBySpuId(pmsSkuInfo.getProductId());
        Map<String, String> attrSkuIdMap = new HashMap<>(16);
        for (PmsSkuInfo relativeSkuAttrInfo : relativeSkuAttrInfoList) {
            String value = relativeSkuAttrInfo.getId();
            StringBuilder key = new StringBuilder();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : relativeSkuAttrInfo.getSkuSaleAttrValueList()) {
                key.append(pmsSkuSaleAttrValue.getSaleAttrValueId());
                key.append("|");
            }
            attrSkuIdMap.put(key.toString(), value);
        }
        String attrSkuIdMapString = JSON.toJSONString(attrSkuIdMap);
        modelMap.addAttribute("skuSaleAttrHashJsonStr", attrSkuIdMapString);
        return "item";
    }
}
