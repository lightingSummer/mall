package club.lightingsummer.mall.api.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author lightingSummer
 * @date 2019/11/19 0019
 */
public class PmsBaseSaleAttr implements Serializable {

    @Id
    @Column
    private String id ;

    @Column
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}