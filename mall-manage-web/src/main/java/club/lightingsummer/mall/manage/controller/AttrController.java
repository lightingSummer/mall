package club.lightingsummer.mall.manage.controller;

import club.lightingsummer.mall.api.bean.PmsBaseAttrInfo;
import club.lightingsummer.mall.api.bean.PmsBaseAttrValue;
import club.lightingsummer.mall.api.service.AttrService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author light
 * @date 2019/11/16 0016 21:56
 */
@Controller
@CrossOrigin
public class AttrController {

    @Reference(interfaceClass = AttrService.class, check = false)
    AttrService attrService;

    @RequestMapping(path = "/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrInfoList(@RequestParam("catalog3Id") String catalog3Id) {
        return attrService.getAttrInfoList(catalog3Id);
    }

    @RequestMapping(path = "/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(@RequestParam("attrId") String attrId) {
        return attrService.getAttrValueList(attrId);
    }
}
