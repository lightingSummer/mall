package club.lightingsummer.mall.user.service;

import club.lightingsummer.mall.user.bean.UmsMember;
import club.lightingsummer.mall.user.bean.UmsMemberReceiveAddress;

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

    /**
     * description: 根据用户id查询收货地址
     *
     * @param memberId 用户id
     * @return java.util.List<club.lightingsummer.mall.user.bean.UmsMemberReceiveAddress>
     */
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
