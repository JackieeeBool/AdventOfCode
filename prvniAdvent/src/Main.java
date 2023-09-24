import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> elves = new ArrayList(); String line;
        BufferedReader fc = new BufferedReader(new FileReader("D:\\prvniAdvent\\src\\kokotinaZasrana.txt"));
        ArrayList<Integer> cisla = new ArrayList<>();
        while ((line = fc.readLine()) != null) {
            if (!(line.isEmpty())) { cisla.add(Integer.parseInt(line)); continue; }
            int sum = 0;
            for (int x : cisla) sum += x;
            cisla = new ArrayList<Integer>();
            elves.add(sum);
        } elves.sort(Comparator.<Integer>reverseOrder()); System.out.println(elves.get(0));
    }
}