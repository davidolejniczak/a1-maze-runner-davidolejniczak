package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Print {
    public static String pathCanonicalMaker(String userpathfactored){
        //converts the users factored path to canonical path that the computer can use to check if its correct
        StringBuilder factoredPath = new StringBuilder(" ");
        for (int index=0; index < userpathfactored.length();index++) {
            char currentChar = userpathfactored.charAt(index);
            if ("R".equals(currentChar) || "F".equals(currentChar) || "L".equals(currentChar)) {
                factoredPath.append((currentChar));
            }
            else if (currentChar >= '0' && currentChar <= '9') {
                int numOfSpace = Integer.parseInt(Character.toString(currentChar));
                index++;
                char currentCharNum = userpathfactored.charAt(index);
                if ("R".equals(currentCharNum)) {
                    for (int n=0; n<numOfSpace; n++){
                        factoredPath.append(currentCharNum);
                    }
                }
                if ("F".equals(currentCharNum)) {
                    for (int n=0; n<numOfSpace; n++){
                        factoredPath.append(currentCharNum);
                    }
                }
                if ("L".equals(currentCharNum)) {
                    for (int n=0; n<numOfSpace; n++){
                        factoredPath.append(currentCharNum);
                    }
                }
            }
        }
        return factoredPath.toString();
    }

    public static String pathFactorized(String solvedpath) {
        //takes in the solved path for a maze in canonical form and converts it too factorized form
        StringBuilder factoredPath = new StringBuilder();
        for (int index = 0;  index< solvedpath.length(); index++) {
            char currentChar = solvedpath.charAt(index);
            if (currentChar == solvedpath.charAt(index+1) && index < solvedpath.length()-1) {
                int numOfTimes = 1;
                while (currentChar == solvedpath.charAt(index+numOfTimes)) {
                    numOfTimes++;
                }
                factoredPath.append(numOfTimes);
                factoredPath.append(currentChar);
            }
            else {
                factoredPath.append(currentChar);
            }
            factoredPath.append(" ");
        }
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
