package club.lightingsummer.mall.api.service;

import club.lightingsummer.mall.api.bean.UmsMemberReceiveAddress;
import club.lightingsummer.mall.api.bean.UmsMember;

import java.util.List;

/**
 * @author lightingSummer
 * @date 2019/11/11 0011
 */
public interface UserService {
    /**
     * description:
     *
     * @return java.util.List<UmsMember>
     */
    List<UmsMember> getAllUsers();

    /**
     * description: 根据用户id查询收货地址
     *
     * @param memberId 用户id
     * @return java.util.List<UmsMemberReceiveAddress>
     */
    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
