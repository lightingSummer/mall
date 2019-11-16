package club.lightingsummer.mall.manage.service.impl;

import club.lightingsummer.mall.api.bean.PmsBaseAttrInfo;
import club.lightingsummer.mall.api.bean.PmsBaseAttrValue;
import club.lightingsummer.mall.api.service.AttrService;
import club.lightingsummer.mall.manage.mapper.PmsBaseAttrInfoMapper;
import club.lightingsummer.mall.manage.mapper.PmsBaseAttrValueMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author light
 * @date 2019/11/16 0016 21:36
 */
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id) {
        Example example = new Example(PmsBaseAttrInfo.class);
        example.createCriteria().andEqualTo("catalog3Id", catalog3Id);
        return pmsBaseAttrInfoMapper.selectByExample(example);
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        Example example = new Example(PmsBaseAttrValue.class);
        example.createCriteria().andEqualTo("attrId", attrId);
        return pmsBaseAttrValueMapper.selectByExample(example);
    }
}
