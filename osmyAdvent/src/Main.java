import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\osmyAdvent\\src\\text.txt"));
            int numberOfTrees = 0;
            int rowLow = 0;
            int rowHigh;
            int columnLow = 0;
            int columnHigh;
            int neco;

            String line;
            line = bufferedReader.readLine();
            Tree[][] forest = new Tree[line.length()][line.length()];

            rowHigh = line.length();
            columnHigh = line.length();
            neco = line.length();

            for (int i = rowLow; i < rowHigh; i++) {
                System.out.println(line);
                for (int j = columnLow; j < columnHigh; j++) {
                    int x = line.charAt(j);
                    if (i == 0 || i == line.length() - 1 || j == 0 || j == line.length() - 1)
                        forest[i][j] = new Tree(x, i, j, 0, true);
                    else
                        forest[i][j] = new Tree(x, i, j, 0,false);
                }
                line = bufferedReader.readLine();
            }

            for (int i = rowLow + 1; i < rowHigh - 1; i++) {
                for (int j = columnLow + 1; j < columnHigh - 1; j++) {
                        for (int k = 0; k < j; k++) {
                            if (forest[i][k].getHeight() >= forest[i][j].getHeight()) {
                                forest[i][j].setVisible(false);
                                break;
                            }
                            forest[i][j].setVisible(true);
                        }
                        if (forest[i][j].isVisible())
                            continue;

                        for (int k = j + 1; k < neco; k++) {
                            if (forest[i][k].getHeight() >= forest[i][j].getHeight()) {
                                forest[i][j].setVisible(false);
                                break;
                            }
                            forest[i][j].setVisible(true);
                        }
                        if (forest[i][j].isVisible())
                            continue;

                        for (int k = 0; k < i; k++) {
                            if (forest[k][j].getHeight() >= forest[i][j].getHeight()) {
                                forest[i][j].setVisible(false);
                                break;
                            }
                            forest[i][j].setVisible(true);
                        }
                        if (forest[i][j].isVisible())
                            continue;

                        for (int k = i + 1; k < neco; k++) {
                            if (forest[k][j].getHeight() >= forest[i][j].getHeight()) {
                                forest[i][j].setVisible(false);
                                break;
                            }
                            forest[i][j].setVisible(true);
                        }
                        if (forest[i][j].isVisible())
                            continue;

                        forest[i][j].setVisible(false);
                }
            }

            for (int i = rowLow + 1; i < rowHigh - 1; i++) {
                for (int j = columnLow + 1; j < columnHigh - 1; j++) {
                    int view1 = 0;
                    int view2 = 0;
                    int view3 = 0;
                    int view4 = 0;

                    for (int k = j - 1; k >= 0; k--) {
                        view1++;
                        if (forest[i][k].getHeight() >= forest[i][j].getHeight())
                            break;
                    }

                    for (int k = j + 1; k < neco; k++) {
                        view2++;
                        if (forest[i][k].getHeight() >= forest[i][j].getHeight())
                            break;
                    }

                    for (int k = i - 1; k >= 0; k--) {
                        view3++;
                        if (forest[k][j].getHeight() >= forest[i][j].getHeight())
                            break;
                    }

                    for (int k = i + 1; k < neco; k++) {
                        view4++;
                        if (forest[k][j].getHeight() >= forest[i][j].getHeight())
                            break;
                    }

                    System.out.println("Vlevo vidi: " + view1 + " Vpravo vidi: " + view2 + " Nahoru vidi: " + view3 + " Dolu vidi: " + view4);

                    forest[i][j].setViewDistance(view1 * view2 * view3 * view4);
                }
            }

            int max = 0;

            for (int i = 0; i < neco; i++) {
                for (int j = 0; j < neco; j++) {
                    if (forest[i][j].isVisible()) {
                        if (forest[i][j].getViewDistance() > max)
                            max = forest[i][j].getViewDistance();
                        numberOfTrees++;
                        System.out.println(i + " | " + j);
                    }
                }
            }

            System.out.println(numberOfTrees);
            System.out.println(max);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
