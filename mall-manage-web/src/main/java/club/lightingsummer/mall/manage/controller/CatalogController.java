package club.lightingsummer.mall.manage.controller;

import club.lightingsummer.mall.api.bean.PmsBaseCatalog1;
import club.lightingsummer.mall.api.bean.PmsBaseCatalog2;
import club.lightingsummer.mall.api.bean.PmsBaseCatalog3;
import club.lightingsummer.mall.api.service.CatalogService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author light
 * @date 2019/11/15 0015 17:09
 */
@Controller
@CrossOrigin
public class CatalogController {

    @Reference(interfaceClass = CatalogService.class, check = false, cache = "lru")
    CatalogService catalogService;

    @RequestMapping(path = "/getCatalog1", method = RequestMethod.POST)
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {
        return catalogService.getCatalog1();
    }

    @RequestMapping(path = "/getCatalog2", method = RequestMethod.POST)
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(@RequestParam("catalog2Id") String catalog2Id) {
        return catalogService.getCatalog2(catalog2Id);
    }

    @RequestMapping(path = "/getCatalog3", method = RequestMethod.POST)
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam("catalog3Id") String catalog3Id) {
        return catalogService.getCatalog3(catalog3Id);
    }
}
