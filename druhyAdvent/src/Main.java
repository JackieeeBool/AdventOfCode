import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\druhyAdvent\\src\\text.txt"));
            long sum = 0;
            int x = 0;
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("X") && line.contains("A")) {
                    x += 3;
                } else if (line.contains("X") && line.contains("B")) {
                    x += 1;
                } else if (line.contains("X") && line.contains("C")) {
                    x += 2;
                } else if (line.contains("Y") && line.contains("A")) {
                    x += 4;
                } else if (line.contains("Y") && line.contains("B")) {
                    x += 5;
                } else if (line.contains("Y") && line.contains("C")) {
                    x += 6;
                } else if (line.contains("Z") && line.contains("A")) {
                    x += 8;
                } else if (line.contains("Z") && line.contains("B")) {
                    x += 9;
                } else if (line.contains("Z") && line.contains("C")) {
                    x += 7;
                }
                sum += x;
                x = 0;
            }

            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*The score for a single round is the score for the shape you selected X LOSE Y DRAW Z WIN
 (1 for Rock, 2 for Paper, and 3 for Scissors)
 plus the score for the outcome of the round
 (0 if you lost, 3 if the round was a draw, and 6 if you won).

 A rock X
 B paper Y
 C scissors Z
 */