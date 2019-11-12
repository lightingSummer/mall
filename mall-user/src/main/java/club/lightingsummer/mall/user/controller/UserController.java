package club.lightingsummer.mall.user.controller;

import club.lightingsummer.mall.user.bean.UmsMember;
import club.lightingsummer.mall.user.bean.UmsMemberReceiveAddress;
import club.lightingsummer.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    @ResponseBody
    public List<UmsMember> index() {
        return userService.getAllUsers();
    }

    @RequestMapping(path = "/getUserReceiveAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getUserReceiveAddress(@RequestParam("id") String memberId) {
        return userService.getReceiveAddressByMemberId(memberId);
    }
}
