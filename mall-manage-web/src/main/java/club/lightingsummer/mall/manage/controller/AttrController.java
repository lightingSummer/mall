package club.lightingsummer.mall.manage.controller;

import club.lightingsummer.mall.api.bean.PmsBaseAttrInfo;
import club.lightingsummer.mall.api.bean.PmsBaseAttrValue;
import club.lightingsummer.mall.api.service.AttrService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author light
 * @date 2019/11/16 0016 21:56
 */
@Controller
@CrossOrigin
public class AttrController {
    private static final Logger logger = LoggerFactory.getLogger(AttrController.class);

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

    @RequestMapping(path = "saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {
        try {
            attrService.saveAttrInfo(pmsBaseAttrInfo);
            return "success";
        } catch (Exception e) {
            logger.error("保存数据失败" + e.getMessage());
            return "fail";
        }
    }
}
