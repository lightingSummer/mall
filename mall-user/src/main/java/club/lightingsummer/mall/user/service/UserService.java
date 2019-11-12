package club.lightingsummer.mall.user.service;

import club.lightingsummer.mall.user.bean.UmsMember;

import java.util.List;

/**
 * @author lightingSummer
 * @date 2019/11/11 0011
 */
public interface UserService {
    /**
     * description:
     *
     * @return java.util.List<club.lightingsummer.mall.user.bean.UmsMember>
     */
    List<UmsMember> getAllUsers();
}
