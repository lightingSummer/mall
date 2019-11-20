package club.lightingsummer.mall.api.service;

import club.lightingsummer.mall.api.bean.PmsBaseAttrInfo;
import club.lightingsummer.mall.api.bean.PmsBaseAttrValue;
import club.lightingsummer.mall.api.bean.PmsBaseSaleAttr;

import java.util.List;

/**
 * @author light
 * @date 2019/11/16 0016 21:35
 */
public interface AttrService {
    /**
     * description: 获取属性信息
     *
     * @param catalog3Id 3级目录id
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsBaseAttrInfo>
     */
    List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id);

    /**
     * description: 获取属性值信息
     *
     * @param attrId 属性id
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsBaseAttrValue>
     */
    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    /**
     * description: 添加或者修改信息
     *
     * @param pmsBaseAttrInfo 待修改信息
     * @return void
     */
    void saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    /**
     * description: 获取所有销售属性
     *
     * @return java.util.List<club.lightingsummer.mall.api.bean.PmsBaseSaleAttr>
     */
    List<PmsBaseSaleAttr> getBaseSaleAttrList();
}
