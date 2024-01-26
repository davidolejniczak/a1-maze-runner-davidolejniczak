package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Compass {
    public static char directionFaced;
    protected static void compassLeft(){
        if (directionFaced == 'N') {
            directionFaced =  'W';
        } else if (directionFaced == 'W') {
            directionFaced = 'S';
        } else if (directionFaced == 'S') {
            directionFaced = 'E';
        } else {
            directionFaced = 'N';
        }
    }
    protected static void compassRight(){
        if (directionFaced == 'N') {
            directionFaced =  'E';
        } else if (directionFaced == 'W') {
            directionFaced = 'N';
        } else if (directionFaced == 'S') {
            directionFaced = 'W';
        } else {
            directionFaced = 'S';
        }
    }
}
