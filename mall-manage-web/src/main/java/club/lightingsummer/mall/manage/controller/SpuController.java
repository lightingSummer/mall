package club.lightingsummer.mall.manage.controller;

import club.lightingsummer.mall.api.bean.PmsProductImage;
import club.lightingsummer.mall.api.bean.PmsProductInfo;
import club.lightingsummer.mall.api.bean.PmsProductSaleAttr;
import club.lightingsummer.mall.api.service.SpuService;
import club.lightingsummer.mall.manage.util.PmsUploadUtil;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author light
 * @date 2019/11/20 0020 21:43
 */
@Controller
@CrossOrigin
public class SpuController {
    @Reference(interfaceClass = SpuService.class, check = false)
    SpuService spuService;

    @RequestMapping(path = "/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        return PmsUploadUtil.uploadImage(multipartFile);
    }

    @RequestMapping(path = "spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId) {
        return spuService.spuImageList(spuId);
    }

    @RequestMapping(path = "spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {
        return spuService.spuSaleAttrList(spuId);
    }

    @RequestMapping(path = "saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping(path = "spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id) {
        return spuService.spuList(catalog3Id);
    }
}
