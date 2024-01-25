package src.main.java.ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    public static int westEntryRow;
    public static int eastEntryRow;
    public static void mazeMaker(String filename) throws IOException {
        BufferedReader readerCount = new BufferedReader(new FileReader(filename));
        String lineCountLoop;
        int mazeRows = 0,mazeColn = 0;
        while ((lineCountLoop = readerCount.readLine()) != null) {
            mazeRows =  lineCountLoop.length();
            for (int index = 0; index < lineCountLoop.length(); index++) {
                mazeColn = index;
            }
        }
        int[][] mazeStorage = new int[mazeRows][mazeColn+1];
        BufferedReader readerPrint = new BufferedReader(new FileReader(filename));
        String linePrintLoop;
        int rowCount = 0;
        while ((linePrintLoop = readerPrint.readLine()) != null) {
            for (int index = 0; index < linePrintLoop.length(); index++) {
                if (linePrintLoop.charAt(index) == '#') {
                    mazeStorage[rowCount][index] = 1;
                } else if (linePrintLoop.charAt(index) == ' ') {
                    mazeStorage[rowCount][index] = 0;
                    if (mazeStorage[rowCount][0] == 0) {westEntryRow = rowCount;}
                    if (mazeStorage[rowCount][mazeColn+1] == 0) {eastEntryRow = rowCount;}
                }
            }
            rowCount++;
            System.out.print(westEntryRow);
            System.out.println(eastEntryRow);
        }
    }
}

