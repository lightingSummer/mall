package club.lightingsummer.mall.user.service.impl;

import club.lightingsummer.mall.user.bean.UmsMember;
import club.lightingsummer.mall.user.mapper.UserMapper;
import club.lightingsummer.mall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lightingSummer
 * @date 2019/11/11 0011
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UmsMember> getAllUsers() {
        return userMapper.selectAllUsers();
    }
}
