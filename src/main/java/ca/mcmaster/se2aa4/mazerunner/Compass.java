package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Compass {
    public static char directionFaced;
    protected static void compassLeftMove(){
        if (directionFaced == 'N') {
            directionFaced =  'W';
        } else if (directionFaced == 'W') {
            directionFaced = 'S';
        } else if (directionFaced == 'S') {
            directionFaced = 'E';
        } else if (directionFaced == 'E') {
            directionFaced = 'N';
        }
    }
    protected static void compassRightMove(){
        if (directionFaced == 'N') {
            directionFaced =  'E';
        } else if (directionFaced == 'W') {
            directionFaced = 'N';
        } else if (directionFaced == 'S') {
            directionFaced = 'W';
        } else if (directionFaced == 'E') {
            directionFaced = 'S';
        }
    }
}
