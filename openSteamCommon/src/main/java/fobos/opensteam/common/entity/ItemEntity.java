package fobos.opensteam.common.entity;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Created by Kirill Listopad on 10/25/14.
 */
public class ItemEntity implements Serializable {

    public ItemEntity(){}

    public ItemEntity(Long id, String materialName, Integer itemViewId) {
        this.id = id;
        this.materialName = materialName;
        this.itemViewId = itemViewId;
    }

    private Long id;
    private String materialName;
    private Integer itemViewId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getItemViewId() {
        return itemViewId;
    }

    public void setItemViewId(Integer itemViewId) {
        this.itemViewId = itemViewId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("materialName", materialName)
                .add("itemViewId", itemViewId)
                .toString();
    }
}
