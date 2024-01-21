package src.main.java.ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    public static void mazeMaker(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String lineCountLoop;
        int mazeRows = 0,mazeColn = 0;
        while ((lineCountLoop = reader.readLine()) != null) {
            mazeRows =  lineCountLoop.length();
            for (int index = 0; index < lineCountLoop.length(); index++) {
                mazeColn = index;
            }
        }

        int[][] mazeStorage = new int[mazeRows][mazeColn];

        String linePrintLoop;
        int rowCount = 0;
        while ((linePrintLoop = reader.readLine()) != null) {
            for (int index = 0; index < linePrintLoop.length(); index++, rowCount++) {
                if (linePrintLoop.charAt(index) == '#') {
                    System.out.print("WALL ");
                    mazeStorage[rowCount][index] = 1;
                } else if (linePrintLoop.charAt(index) == ' ') {
                    System.out.print("PASS ");
                    mazeStorage[rowCount][index] = 0;
                }
            }
            System.out.print(System.lineSeparator());
        }
    }
}
