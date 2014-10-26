package fobos.opensteam.common;

/**
 * Created by md on 10/25/14.
 */
public enum RequestType {
    ITEMS(1);

    private final int index;

    private RequestType(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static RequestType valueOf(int index){
        for (RequestType t: RequestType.values()){
            if (t.getIndex() == index) return t;
        }
        throw new RuntimeException(String.format("No RequestType with index %s", index));
    }
}
