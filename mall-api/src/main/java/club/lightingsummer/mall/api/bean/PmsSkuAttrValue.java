package club.lightingsummer.mall.api.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author lightingSummer
 * @date 2019/11/19 0019
 */
public class PmsSkuAttrValue implements Serializable {

    @Id
    @Column
    private String id;

    @Column
    private String attrId;

    @Column
    private String valueId;

    @Column
    private String skuId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }
}
