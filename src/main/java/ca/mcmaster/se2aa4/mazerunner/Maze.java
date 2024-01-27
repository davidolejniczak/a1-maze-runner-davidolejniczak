package src.main.java.ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serial;

public class Maze {
    public static int rowLocation;
    public static int colnLocation;
    //public static int currentLocation[] = new int[2]; // maybe delete if not used anywhere
    static int westEntry[] = new int[2];
    static int eastEntry[] = new int[2];
    public static int[][] mazeStorage;
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
        //for (int i = 0; i < mazeStorage.length; i++) {
        //            for (int j = 0; j < mazeStorage[i].length; j++) {
        //                System.out.print(mazeStorage[i][j]);
        //            }
        //            System.out.println();
        //}
    }
    private static void endFinder(){
        //int numOfColns = mazeStorage[0].length-1;
        //System.out.println("NUM OF COLMS IN MAZE" + numOfColns);
        for (int i = 0; i < mazeStorage.length; i++) {
            if (mazeStorage[i][0] == 0) {
                westEntry[0] = i;
                westEntry[1] = 0;
            }
            if (mazeStorage[i][mazeStorage[i].length-1] == 0) {
                eastEntry[0] = i;
                eastEntry[1] = mazeStorage[i].length-1;
                //System.out.println(eastEntry[1]+ " MAZE ENDFINER ");
            }
        }
    }
    public static void mazeStartWest(){
       endFinder();
       rowLocation = westEntry[0];
       //currentLocation[0] = westEntry[0];
       colnLocation = 0;
       //currentLocation[1] = 0;
       Compass.directionFaced = 'E';
       //System.out.println(rowLocation);
       //System.out.println(colnLocation);
       //System.out.print(westEntry[0]); System.out.print(westEntry[1]); System.out.println("WEST ENTRY");
       //System.out.print(eastEntry[0]); System.out.print(eastEntry[1]); System.out.println("EAST ENTRY");
    }
    public static void mazeStartEast(){
        rowLocation = eastEntry[0];
        //currentLocation[0] = eastEntry[0];
        colnLocation = eastEntry[1];
        //currentLocation[1] = eastEntry[1];
        Compass.directionFaced = 'W';
    }

   //public static void updateLocation() {
        //currentLocation[0] = rowLocation;
        //currentLocation[1] = colnLocation;
//
}

