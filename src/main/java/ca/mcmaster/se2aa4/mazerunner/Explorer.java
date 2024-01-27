package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Explorer {

    public static String pathFinder(String filepath) {
        StringBuilder pathWay = new StringBuilder();
        System.out.println("Starting from West side of Maze");
        Maze.mazeStartWest();
        while (Maze.rowLocation != Maze.eastEntry[0] || Maze.colnLocation != Maze.eastEntry[1]) {
            if (Path.fowardCheck(Maze.rowLocation, Maze.colnLocation, Compass.directionFaced)) {
                //open foward space only case
                moveSpaceFoward();
                pathWay.append("F");
            }
            if (rightCheck(Maze.rowLocation, Maze.colnLocation)) {
                //open right path case
                Compass.compassRightMove();
                pathWay.append("R");
            } else if (Path.fowardCheck(Maze.rowLocation, Maze.colnLocation, Compass.directionFaced) == false && rightCheck(Maze.rowLocation, Maze.colnLocation) == false){
                //foward and right wall blocked move
                Compass.compassLeftMove();
                pathWay.append("L");
            } else {
                //dead end case
                Compass.compassLeftMove();
                pathWay.append("L");
                Compass.compassLeftMove();
                pathWay.append("L");
            }
            System.out.println(pathWay);
        }
        return pathWay.toString();
    }

    private static boolean rightCheck(int row, int colm){
        if (Compass.directionFaced == 'N') {
            if (Maze.mazeStorage[row][colm+1] == 0) {return true;}
        }
        if (Compass.directionFaced == 'W') {
            if (Maze.mazeStorage[row-1][colm] == 0) {return true;}
        }
        if (Compass.directionFaced == 'S') {
            if (Maze.mazeStorage[row][colm-1] == 0) {return true;}
        }
        if (Compass.directionFaced == 'E') {
            if (Maze.mazeStorage[row+1][colm] == 0) {
                //System.out.println("right CHECK GOOD");
                return true;}
        }
        //System.out.println("right CHECK BAD");
        return false;
        }

    private static void moveSpaceFoward(){
        if (Path.fowardCheck(Maze.rowLocation, Maze.colnLocation, Compass.directionFaced)) {
            if (Compass.directionFaced == 'N') {
                Maze.rowLocation = Maze.rowLocation - 1;
            } else if (Compass.directionFaced == 'W') {
                Maze.colnLocation = Maze.colnLocation - 1;
            } else if (Compass.directionFaced == 'S') {
                Maze.rowLocation = Maze.rowLocation + 1;
            } else if (Compass.directionFaced == 'E') {
                Maze.colnLocation = Maze.colnLocation + 1;
            }
            //System.out.println("FOWARD MOVE GOOD 2.2");
            //Maze.updateLocation();
        }
        //System.out.println("ERROR 2 Bad");
    }

}