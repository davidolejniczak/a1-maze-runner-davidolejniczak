package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Path {

    public static boolean pathCheck(String userpath){

        return false;
    }

    public static String pathFinder(String filepath){
        //finds the correct path throw the maze using a right hand strat while recording all moves taken
        return "RFFFFRLFFF";
    }

    private static boolean rightMove(int row, int colm) {
        if (rightCheck(row, colm)) {
            Maze.mazeStorage[row][colm] = Maze.mazeStorage[row][colm+1];
            Compass.compassRight();
            return true;
        }
        return false;
    }
    private static boolean leftMove(int row, int colm) {
        if (leftCheck(row, colm)) {
            Maze.mazeStorage[row][colm] = Maze.mazeStorage[row][colm-1];
            Compass.compassLeft();
            return true;
        }
        return false;
    }

    private static boolean fowardMove(int row, int colm) {
        if (fowardCheck(row, colm)) {
            Maze.mazeStorage[row][colm] = Maze.mazeStorage[row+1][colm];
            return true;
        }
        return false;
    }

    private static boolean rightCheck(int row, int colm) {
        if (Maze.mazeStorage[row][colm+1] == 0) {return true;}
        return false;
    }
    private static boolean fowardCheck(int row, int colm) {
        if (Maze.mazeStorage[row+1][colm] == 0) {return true;}
        return false;
    }
    private static boolean leftCheck(int row, int colm) {
        if (Maze.mazeStorage[row][colm-1] == 0) {return true;}
        return false;
    }
}
