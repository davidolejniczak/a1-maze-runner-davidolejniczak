package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Path {
    public static boolean userCheck(String currentPath) {
        try {
            Maze.mazeStartWest();
            if (pathCheck(currentPath)) {
                System.out.println("Starting on the West side ");
                return true;
            }
            Maze.mazeStartEast();
            //printLoc();
            //System.out.println("PRINT LOC 1");
            if (pathCheck(currentPath)) {
                System.out.println("Starting on the East side ");
                return true;
            }
        } catch (Exception e) {System.out.println("Given path is incorrect by having too many moves");}
        return false;
    }
    private static boolean pathCheck(String userpath) {
        //System.out.println(userpath + "STRING BEING READ");
        // re do this so that osmeone can spin around in one spot and it wont die on them
        // so it doesn't crash when someone just hits a wall
        char currentChar;
        int charCount = 0;
        while (charCount < userpath.length()) {
            //printLoc();
            //System.out.println("printloc 1");
            currentChar = userpath.charAt(charCount);
            //System.out.println(currentChar);
            if (currentChar == 'F') {
                if (!fowardMove(Maze.rowLocation, Maze.colnLocation)) {
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

    private static boolean endCondition(){
        if (Maze.rowLocation == Maze.eastEntry[0] && Maze.colnLocation == Maze.eastEntry[1]) {return true;}
        if (Maze.rowLocation == Maze.westEntry[0] && Maze.colnLocation == Maze.westEntry[1]) {return true;}
        return false;
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
            //Maze.updateLocation();
            return true;
        }
        //System.out.println("ERROR 2");
        return false;
    }

    static boolean fowardCheck(int row, int colm, char compass) {
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
                return true;}
        }
        return false;
    }

}

