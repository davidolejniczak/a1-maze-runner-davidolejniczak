package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Print {

    public static String pathCanonicalMaker(String userpathfactored){
        //converts the users factored path to canonical path that the computer can use to check if its correct
        StringBuilder factoredPath = new StringBuilder(" ");
        return factoredPath.toString();
    }

    public static String pathFactorized(String solvedpath) {
        //takes in the solved path for a maze in canonical form and converts it too factorized form
        StringBuilder factoredPath = new StringBuilder();
        factoredPath.append("");
        return factoredPath.toString();
    }

    public static void printPath(String solvedPath) {
        System.out.println("Starting from the west side of the maze");
        System.out.println(solvedPath);
    }

    public static void pathResult(boolean result) {
        if (result) {System.out.println("Correct Path");return;}
        System.out.println("Incorrect Path");
    }


}
