package fobos.opensteam.common.entity;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * Created by md on 10/25/14.
 */
public class ItemEntity implements Serializable {

    public ItemEntity(){}

    public ItemEntity(Long id, Integer itemId, Integer itemViewId) {
        this.id = id;
        this.itemId = itemId;
        this.itemViewId = itemViewId;
    }

    private Long id;
    private Integer itemId;
    private Integer itemViewId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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
                .add("itemId", itemId)
                .add("itemViewId", itemViewId)
                .toString();
    }
}
