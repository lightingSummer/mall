package club.lightingsummer.mall.user.mapper;

import club.lightingsummer.mall.api.bean.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author lightingSummer
 * @date 2019/11/11 0011
 */
public interface UserMapper extends Mapper<UmsMember> {

    /**
     * description: 获取所有用户
     *
     * @return java.util.List<UmsMember>
     */
    List<UmsMember> selectAllUsers();
}
