import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\ctvrtyAdvent\\src\\text.txt"));
            int sum = 0;
            int a, b, c, d;
            String line;
            String firstInterval;
            String secondInterval;

            while ((line = bufferedReader.readLine()) != null) {
                firstInterval = line.substring(0, line.indexOf(','));
                secondInterval = line.substring(line.indexOf(',') + 1, line.length());

                a = Integer.parseInt(firstInterval.substring(0, firstInterval.indexOf('-')));
                b = Integer.parseInt(firstInterval.substring(firstInterval.indexOf('-') + 1, firstInterval.length()));
                c = Integer.parseInt(secondInterval.substring(0, secondInterval.indexOf('-')));
                d = Integer.parseInt(secondInterval.substring(secondInterval.indexOf('-') + 1, secondInterval.length()));

                if (a >= c && b <= d || c >= a && d <= b || a >= c && a <= d || b >= c && b <= d || c >= a && c <= b || d >= a && d <= b)
                    sum += 1;
            }

            System.out.println(sum);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
