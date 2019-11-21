package club.lightingsummer.mall.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author light
 * @date 2019/11/21 0021 21:40
 */
@Controller
public class ItemController {

    @RequestMapping(path = "/index")
    public String indexTest() {
        return "index";
    }
}
