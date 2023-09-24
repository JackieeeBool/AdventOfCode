import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\sestyAdvent\\src\\text.txt"));
            String line;
            char[] chars;
            line = bufferedReader.readLine();

            for (int i = 0; i < line.length() - 4; i++) {
                chars = line.substring(i, i + 14).toCharArray(); /// array len 4
                int w = 0;
                for (int j = 0; j < 14; j++) {
                    for (char y : chars) {
                        if (chars[j] == y)
                            w++;
                    }
                    if (j + 1 == chars.length && w <= chars.length) {
                        System.out.println(i + 14);
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
