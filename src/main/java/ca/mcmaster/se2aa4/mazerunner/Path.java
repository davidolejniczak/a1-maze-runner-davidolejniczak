package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Path {
    // make a path check functoin that first checks from west size then from east side entry
    public static boolean userCheck(String currentPath) {
        try {
            Maze.mazeStartWest();
            if (pathCheck(currentPath)) {
                System.out.println("WEST PATH WORKS");
                return true;
            }
            Maze.mazeStartEast();
            //printLoc();
            //System.out.println("PRINT LOC 1");
            if (pathCheck(currentPath)) {
                System.out.println("EAST PATH WORKS");
                return true;
            }
        } catch (Exception e) {System.out.println("Given is incorrect by having too many moves");}
        return false;
    }
    private static boolean pathCheck(String userpath) {
        //System.out.println(userpath + "STRING BEING READ");
        char currentChar;
        int charCount = 0;
        while (charCount < userpath.length()) {
            //printLoc();
            //System.out.println("printloc 1");
            currentChar = userpath.charAt(charCount);
            //System.out.println(currentChar);
            if (currentChar == 'F') {
                if (!fowardMove(Maze.rowLocation, Maze.colnLocation)) {
                    //System.out.println("ERROR 1");
                    return false;
                }
            }
            if (currentChar == 'L') {
                //System.out.println("LEFT HAND TURN");
                leftMove();
            }
            if (currentChar == 'R') {
                //System.out.println("RIGHT HAND TURN");
                rightMove();
            }
            charCount++;
            //PrintLoc();
            //System.out.println("printloc 2");
        }
        if (endCondition()) {
            return true;
        }
        return false;
    }

    private static void printLoc() {
        System.out.print(Maze.rowLocation);
        System.out.println(Maze.colnLocation);
    }

    public static boolean endCondition(){
        if (Maze.rowLocation == Maze.eastEntry[0] && Maze.colnLocation == Maze.eastEntry[1]) {return true;}
        if (Maze.rowLocation == Maze.westEntry[0] && Maze.colnLocation == Maze.westEntry[1]) {return true;}
        return false;
    }
    public static String pathFinder(String filepath){
        //finds the correct path throw the maze using a right hand strat while recording all moves taken
        return "RFFFFRLFFF";
    }
    private static void rightMove() {
            //System.out.println(Compass.directionFaced + " DIRECTINON FACED 1 ");
            Compass.compassRightMove();
            //System.out.println(Compass.directionFaced + " DIRECTINON FACED 2 ");
    }
    private static void leftMove() {
            Compass.compassLeftMove();
    }

    private static boolean fowardMove(int row, int colm) {
        if (fowardCheck(row, colm, Compass.directionFaced)) {
            if (Compass.directionFaced == 'N') {
                 Maze.rowLocation = Maze.rowLocation - 1;
            }
            if (Compass.directionFaced == 'W') {
                 Maze.colnLocation = Maze.colnLocation - 1;
            }
            if (Compass.directionFaced == 'S') {
                Maze.rowLocation = Maze.rowLocation + 1;
            }
            if (Compass.directionFaced == 'E') {
                Maze.colnLocation = Maze.colnLocation + 1;
            }
            //System.out.println("FOWARD MOVE GOOD 2.2");
            return true;
        }
        //System.out.println("ERROR 2");
        return false;
    }

    private static boolean fowardCheck(int row, int colm, char compass) {
        if (compass == 'N') {
            if (Maze.mazeStorage[row-1][colm] == 0) {return true;}
        }
        if (compass == 'W') {
            if (Maze.mazeStorage[row][colm-1] == 0) {return true;}
        }
        if (compass == 'S') {
            if (Maze.mazeStorage[row+1][colm] == 0) {return true;}
        }
        if (compass == 'E') {
            if (Maze.mazeStorage[row][colm+1] == 0) {
                //System.out.println("FOWARD CHECK GOOD");
                return true;}
        }
        //System.out.println("FOWARD CHECK BAD");
        return false;
    }

}

