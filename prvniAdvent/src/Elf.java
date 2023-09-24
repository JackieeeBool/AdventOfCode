import java.util.ArrayList;

public class Elf {
    private ArrayList<Item> items;

    public Elf() {
        items = new ArrayList<Item>();
    }

    public boolean addItem(int calory) {
        return items.add(new Item(calory));
    }

    public int getFatestItem() {
        int highest = 0;
        for (Item x : items) {
            if (x.calory > highest)
                highest = x.calory;
        }
        return highest;
    }

    public int getSum() {
        int sum = 0;
        for (Item item : items) {
            sum += item.calory;
        }
        return sum;
    }
}
