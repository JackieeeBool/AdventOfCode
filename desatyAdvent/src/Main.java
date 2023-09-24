import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            int numberOfCycles = 1;
            int x = 1;
            int sum = 0;
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\desatyAdvent\\src\\text.txt"));

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("noop")) {
                    numberOfCycles++;
                } else {
                    x += Integer.parseInt(line.substring(5));
                    numberOfCycles += 2;
                }

                if (numberOfCycles == 20 || numberOfCycles == 60 || numberOfCycles == 100 || numberOfCycles == 160 || numberOfCycles == 220) {
                    sum += (x * numberOfCycles);
                }
            }

            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
