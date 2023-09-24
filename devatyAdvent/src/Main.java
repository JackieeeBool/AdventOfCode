import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String line;
        int xH = 0;
        int xT = 0;
        int yH = 0;
        int yT = 0;

        try {
            Set<String> talePath = new HashSet<>();
            LinkedList<Knot> knots = new LinkedList<>();
            talePath.add("0, 0");
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\devatyAdvent\\src\\text.txt"));

            for (int i = 0; i < 10; i++) {
                knots.add(new Knot(0, 0));
            }

            while ((line = bufferedReader.readLine()) != null) {
                char move;
                int number;

                move = line.charAt(0);
                number = Integer.parseInt(line.substring(2));

                for (int i = 0; i < number; i++) {
                    if (move == 'U') {
                        knots.getFirst().setY(knots.getFirst().getY() + 1);
                    } else if (move == 'D') {
                        knots.getFirst().setY(knots.getFirst().getY() + - 1);
                    } else if (move == 'L') {
                        knots.getFirst().setX(knots.getFirst().getX() + 1);
                    } else {
                        knots.getFirst().setX(knots.getFirst().getX() - 1);
                    }

                    for (int j = 0; j < knots.size() - 1; j++) {
                        if (knots.get(j).getX() - knots.get(j + 1).getX() >= -1 && knots.get(j).getX() - knots.get(j + 1).getX() <= 1
                                && knots.get(j).getY() - knots.get(j + 1).getY() >= -1 && knots.get(j).getY() - knots.get(j + 1).getY() <= 1) {
                            continue;
                        }

                        if (knots.get(j).getX() == knots.get(j + 1).getX()) {
                            if (knots.get(j).getY() > knots.get(j + 1).getY()) {
                                knots.get(j + 1).setY(knots.get(j + 1).getY() + 1);
                            } else
                                knots.get(j + 1).setY(knots.get(j + 1).getY() - 1);
                        } else if (knots.get(j).getY() == knots.get(j + 1).getY()) {
                            if (knots.get(j).getX() < knots.get(j + 1).getX()) {
                                knots.get(j + 1).setX(knots.get(j + 1).getX() - 1);
                            } else
                                knots.get(j + 1).setX(knots.get(j + 1).getX() + 1);
                        } else  {
                            if (knots.get(j).getY() - knots.get(j + 1).getY() >= 1) {
                                knots.get(j + 1).setY(knots.get(j + 1).getY() + 1);
                            } else {
                                knots.get(j + 1).setY(knots.get(j + 1).getY() - 1);
                            }
                            if (knots.get(j).getX() - knots.get(j + 1).getX() <= -1) {
                                knots.get(j + 1).setX(knots.get(j + 1).getX() - 1);
                            } else {
                                knots.get(j + 1).setX(knots.get(j + 1).getX() + 1);
                            }
                        }
                    }

                    String pom = knots.getLast().getX() + ", " + knots.getLast().getY();
                    System.out.println(pom);
                    talePath.add(pom);
                }
            }

            System.out.println(talePath.size());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
