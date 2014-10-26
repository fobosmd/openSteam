package fobos.opensteam.common;

/**
 * Created by md on 10/25/14.
 */
public enum ResponseType {
    ITEMS(10001);

    private final int index;

    private ResponseType(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static ResponseType valueOf(int index){
        for (ResponseType t: ResponseType.values()){
            if (t.getIndex() == index) return t;
        }
        throw new RuntimeException(String.format("No ResponseType with index %s", index));
    }
}
