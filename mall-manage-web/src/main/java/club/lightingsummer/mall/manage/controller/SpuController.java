package club.lightingsummer.mall.manage.controller;

import club.lightingsummer.mall.manage.util.PmsUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author light
 * @date 2019/11/20 0020 21:43
 */
@Controller
@CrossOrigin
public class SpuController {
    @RequestMapping(path = "/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
        return PmsUploadUtil.uploadImage(multipartFile);
    }
}
