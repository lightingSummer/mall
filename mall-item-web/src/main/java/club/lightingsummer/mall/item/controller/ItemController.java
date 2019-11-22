package club.lightingsummer.mall.item.controller;

import club.lightingsummer.mall.api.bean.PmsSkuInfo;
import club.lightingsummer.mall.api.service.SkuService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author light
 * @date 2019/11/21 0021 21:40
 */
@Controller
public class ItemController {
    @Reference(interfaceClass = SkuService.class, check = false)
    SkuService skuService;

    @RequestMapping(path = "{skuId}.html")
    public String item(@PathVariable String skuId, ModelMap modelMap) {
        PmsSkuInfo pmsSkuInfo = skuService.getSkuInfoById(skuId);
        modelMap.addAttribute("skuInfo",pmsSkuInfo);
        return "item";
    }
}
