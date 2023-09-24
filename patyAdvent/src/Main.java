import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\patyAdvent\\src\\text.txt"));
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<Stack> stacks = new ArrayList<>();
            Stack sameOrder = new Stack();

            long startTime = System.currentTimeMillis();

            String line;
            int move;
            int from;
            int to;
            int x = 0;

            for (int i = 0; i < 8; i++) {
                line = bufferedReader.readLine();
                line = line.concat("                                   ");
                arrayList.add(line);
            }
            for (int i = 0; i < 9; i++) {
                stacks.add(new Stack<String>());
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 7; j >= 0; j--) {
                    if (arrayList.get(j).substring(x, x + 3).isBlank()) {
                        continue;
                    }
                    stacks.get(i).push(arrayList.get(j).substring(x, x + 3));
                }
                x += 4;
            }
            bufferedReader.readLine();
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                move = Integer.parseInt(line.substring(line.indexOf("move ") + 5, line.indexOf(" from ")));
                from = Integer.parseInt(line.substring(line.indexOf("from ") + 5, line.indexOf(" to ")));
                to = Integer.parseInt(line.substring(line.indexOf("to ") + 3, line.length()));
                for (int i = 0; i < move; i++) {
                    sameOrder.push(stacks.get(from - 1).pop());
                }

                for (int i = 0; i < move; i++) {
                    stacks.get(to - 1).push(sameOrder.pop());
                }
            }
           for (Stack a : stacks) {
                for (int i = 0; i < a.size(); i++) {
                    System.out.print(a.get(i) + " ");
                }
                System.out.println();
            }

            System.out.println(System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}