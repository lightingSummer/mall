package club.lightingsummer.mall.manage.controller;

import club.lightingsummer.mall.api.bean.PmsSkuInfo;
import club.lightingsummer.mall.api.service.SkuService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author light
 * @date 2019/11/20 0020 21:43
 */
@Controller
@CrossOrigin
public class SkuController {

    @Reference(interfaceClass = SkuService.class, check = false)
    private SkuService skuService;

    @RequestMapping(path = "/saveSkuInfo")
    @ResponseBody
    public String saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        // 将spuId封装给productId
        pmsSkuInfo.setProductId(pmsSkuInfo.getSpuId());
        // 处理默认图片
        String skuDefaultImg = pmsSkuInfo.getSkuDefaultImg();
        if (StringUtils.isBlank(skuDefaultImg)) {
            pmsSkuInfo.setSkuDefaultImg(pmsSkuInfo.getSkuImageList().get(0).getImgUrl());
        }
        skuService.saveSkuInfo(pmsSkuInfo);
        return "success";
    }
}