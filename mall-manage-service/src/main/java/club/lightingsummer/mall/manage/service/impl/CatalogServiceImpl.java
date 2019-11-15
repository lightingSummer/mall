package club.lightingsummer.mall.manage.service.impl;

import club.lightingsummer.mall.api.bean.PmsBaseCatalog1;
import club.lightingsummer.mall.api.bean.PmsBaseCatalog2;
import club.lightingsummer.mall.api.bean.PmsBaseCatalog3;
import club.lightingsummer.mall.api.service.CatalogService;
import club.lightingsummer.mall.manage.mapper.PmsBaseCatalog1Mapper;
import club.lightingsummer.mall.manage.mapper.PmsBaseCatalog2Mapper;
import club.lightingsummer.mall.manage.mapper.PmsBaseCatalog3Mapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author light
 * @date 2019/11/15 0015 17:43
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        Example example = new Example(PmsBaseCatalog2.class);
        example.createCriteria().andEqualTo("catalog1Id", catalog1Id);
        return pmsBaseCatalog2Mapper.selectByExample(example);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        Example example = new Example(PmsBaseCatalog3.class);
        example.createCriteria().andEqualTo("catalog2Id", catalog2Id);
        return pmsBaseCatalog3Mapper.selectByExample(example);
    }
}
