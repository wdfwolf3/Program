package program.win;

/**
 * Created by wdfwolf3 on 2017/6/26.
 */
public class KeyEntity {
    private String name;
    private String value;
    private int flag;

    public KeyEntity(String name, String value, int flag) {
        this.name = name;
        this.value = value;
        this.flag = flag;
    }

    public KeyEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

