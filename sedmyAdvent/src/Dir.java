import java.util.ArrayList;

public class Dir {
    public String history; /// /sds/sdsd/sdsds
    public String name;
    public int size;

    public Dir(String name, String history, int size) {
        this.name = name;
        this.history = history;
        this.size = size;
    }

    public String getHistory() {
        return history;
    }
}
