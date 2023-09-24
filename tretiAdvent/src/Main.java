import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\tretiAdvent\\src\\text.txt"));
            String line;
            ArrayList<String> list = new ArrayList<>();
            char x = '-';
            int sum = 0;

            long startTime = System.currentTimeMillis();

            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
                list.add(bufferedReader.readLine());
                list.add(bufferedReader.readLine());

                for (int i = 0; i < list.get(0).length(); i++) {
                    if (list.get(1).contains("" + list.get(0).charAt(i) + "") && list.get(2).contains("" + list.get(0).charAt(i) + "")) {
                        x = list.get(0).charAt(i);
                        break;
                    }
                }

                if (x >= 'a' && x <= 'z') {
                    sum += (int) x - 96;
                }
                else if (x >= 'A' && x <= 'Z') {
                    sum += (int) x - 38;
                }

                list.clear();
            }

            System.out.println(System.currentTimeMillis() - startTime);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
Lowercase item types a through z have priorities 1 through 26.
Uppercase item types A through Z have priorities 27 through 52.
*/
