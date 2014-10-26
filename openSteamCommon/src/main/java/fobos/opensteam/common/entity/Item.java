package fobos.opensteam.common.entity;

/**
 * Created by md on 10/25/14.
 */
public class Item {

    public Item(){}

    public Item(Long id, Integer itemId, Integer itemViewId) {
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
}
