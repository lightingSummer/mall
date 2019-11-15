package club.lightingsummer.mall.api.service;

import club.lightingsummer.mall.api.bean.PmsBaseCatalog1;
import club.lightingsummer.mall.api.bean.PmsBaseCatalog2;
import club.lightingsummer.mall.api.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @author light
 * @date 2019/11/15 0015 17:04
 */
public interface CatalogService {
    /**
     * description: 获取一级目录
     *
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsBaseCatalog1>
     */
    List<PmsBaseCatalog1> getCatalog1();

    /**
     * description: 获取二级目录
     *
     * @param catalog1Id 一级目录id
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsBaseCatalog2>
     */
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * description: 获取三级目录
     *
     * @param catalog2Id 二级目录id
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsBaseCatalog3>
     */
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
