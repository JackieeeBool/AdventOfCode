import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\sedmyAdvent\\src\\text.txt"));
            ArrayList<Dir> dirs = new ArrayList<>();
            dirs.add(new Dir("/", "/", 0));
            ArrayList<MyFile> files = new ArrayList<>();
            ArrayList<String> firstUsed = new ArrayList<>();
            String line;
            String innerLine;
            ArrayList<String> history = new ArrayList<>();
            int sum = 0;

            line = bufferedReader.readLine();

            while (line != null && !line.equalsIgnoreCase("$ cd a")) {
                if (line.contains("dir")) {
                    firstUsed.add(line.substring(line.indexOf(' ') + 1));
                }
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            bufferedReader = new BufferedReader(new FileReader("D:\\sedmyAdvent\\src\\text.txt"));

            line = bufferedReader.readLine();

            while (line != null) {
                if (line.contains("$ cd")) {
                    switch (line.substring(5)) {
                        case "..":
                            history.remove(history.size() - 1);
                            break;
                        default:
                            String name = line.substring(line.lastIndexOf(" ") + 1);
                            history.add(name);
                            break;
                    }
                    line = bufferedReader.readLine();
                } else if (line.contains("$ ls")) {
                    String current_position = String.join(",", history);
                    line = bufferedReader.readLine();
                    while (line != null && !line.contains("$")) {
                        current_position = String.join(",", history);
                        String[] content = line.split(" ");
                        if (line.contains("dir")) {
                            current_position = current_position + "," + line.substring(4);
                            dirs.add(new Dir(content[1], current_position, 0));
                        } else {
                            files.add(new MyFile(content[1], current_position, Integer.parseInt(content[0])));
                        }
                        line = bufferedReader.readLine();
                    }
                }
            }

            for (Dir x : dirs) {
                for (MyFile y : files) {
                    if (y.getHistory().contains(x.getHistory())) {
                        x.size += y.value;
                       // System.out.println("Adding: " + y.name + " (" + y.history + ")" + " |" + " To: " + x.name + " (" + x.history + ")");
                    }
                }
            }

            for (Dir x : dirs) {
               // System.out.println("name: " + x.name + " size: " + x.size);
                if (x.size <= 100000)
                    sum += x.size;
            }

            Dir topTopDir = new Dir("///", "0000000000", 0);

            for (Dir x : dirs) {
                if (x.size > topTopDir.size) {
                    topTopDir = x;
                    System.out.println(x.name + " " + x.size + " " + x.getHistory());
                }
            }
            sum = 70000000;
            int cisloPico = 30000000 - (70000000 - topTopDir.size);
            System.out.println(cisloPico);
            for (Dir x : dirs) {
                // System.out.println("name: " + x.name + " size: " + x.size);
                if (x.size < sum && x.size >= cisloPico)
                    sum = x.size;
            }
            System.out.println(sum);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}