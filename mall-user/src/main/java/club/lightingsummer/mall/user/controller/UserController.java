package club.lightingsummer.mall.user.controller;

import club.lightingsummer.mall.user.bean.UmsMember;
import club.lightingsummer.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lightingSummer
 * @date 2019/11/11 0011
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(name = "/index")
    @ResponseBody
    public List<UmsMember> index() {
        return userService.getAllUsers();
    }
}
