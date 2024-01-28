package src.main.java.ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
    public static int rowLocation;
    public static int colnLocation;
    public static int westEntry[] = new int[2];
    public static int eastEntry[] = new int[2];
    public static int[][] mazeStorage;
    public static char startSide;
    public static void mazeMaker(String filename) throws IOException {
        BufferedReader readerCount = new BufferedReader(new FileReader(filename));
        String lineCountLoop;
        int mazeRows = 0,mazeColn = 0;
        while ((lineCountLoop = readerCount.readLine()) != null) {
            mazeRows =  lineCountLoop.length();
            for (int index = 0; index <= lineCountLoop.length(); index++) {
                mazeColn = index;
            }
        }
        mazeStorage = new int[mazeRows][mazeColn];
        BufferedReader readerPrint = new BufferedReader(new FileReader(filename));
        String linePrintLoop;
        int rowCount = 0;
        while ((linePrintLoop = readerPrint.readLine()) != null) {
            for (int index = 0; index < linePrintLoop.length(); index++) {
                if (linePrintLoop.charAt(index) == '#') {
                    mazeStorage[rowCount][index] = 1;
                } else if (linePrintLoop.charAt(index) == ' ') {
                    mazeStorage[rowCount][index] = 0;
                }
            }
            rowCount++;
        }
    }
    private static void endFinder(){

        for (int i = 0; i < mazeStorage.length; i++) {
            if (mazeStorage[i][0] == 0 && i+2>mazeStorage.length) //Handling wired error where extra line of 0 shows up
            {
                break;
            }else if (mazeStorage[i][mazeStorage[i].length-1] == 0) {
                eastEntry[0] = i;
                eastEntry[1] = mazeStorage[i].length-1;
            }
            if (mazeStorage[i][0] == 0 && i+2>mazeStorage.length) //Handling wired error where extra line of 0 shows up
                {
                break;
            }else if (mazeStorage[i][0] == 0) {
                    westEntry[0] = i;
                    westEntry[1] = 0;
            }
        }
    }
    public static void mazeStartWest(){
       endFinder();
       rowLocation = westEntry[0];
       colnLocation = 0;
       Compass.directionFaced = 'E';
       startSide = 'W';
    }
    public static void mazeStartEast(){
        rowLocation = eastEntry[0];
        colnLocation = eastEntry[1];
        Compass.directionFaced = 'W';
        startSide = 'E';
    }
}

