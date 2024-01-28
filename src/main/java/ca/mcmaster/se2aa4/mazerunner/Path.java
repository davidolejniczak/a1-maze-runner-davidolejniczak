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
            if (pathCheck(currentPath)) {
                System.out.println("Starting on the East side ");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Given path is incorrect by having too many moves");
        }
        return false;
    }
    private static boolean pathCheck(String userpath) {
        if (userpath.isEmpty()) {return false;}
        char currentChar;
        int charCount = 0;
        while (charCount < userpath.length()) {
            currentChar = userpath.charAt(charCount);
            if (currentChar == 'F') {
                if (fowardMove(Maze.rowLocation, Maze.colnLocation) == false) {
                    return false;
                }
            }
            if (currentChar == 'L') {
                leftMove();
            }
            if (currentChar == 'R') {
                rightMove();
            }
            charCount++;
        }
        char userpathLastChar = userpath.charAt(userpath.length()-1);
        if (userpathLastChar == 'F' || userpathLastChar == 'R' || userpathLastChar == 'L') {
            if (endCondition()) {
                return true;
            }
            return false;
        }
        return false;
    }

    private static boolean endCondition(){
        if (Maze.rowLocation == Maze.eastEntry[0] && Maze.colnLocation == Maze.eastEntry[1] && Maze.startSide == 'W') {return true;}
        if (Maze.rowLocation == Maze.westEntry[0] && Maze.colnLocation == Maze.westEntry[1] && Maze.startSide == 'E') {return true;}
        return false;
    }
    private static void rightMove() {
            Compass.compassRightMove();
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
            return true;
        }
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

