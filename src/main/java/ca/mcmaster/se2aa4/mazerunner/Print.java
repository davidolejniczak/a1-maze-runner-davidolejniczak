package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Print {
    private static char currentChar;
    private static char nextChar;

    public static String pathCanonicalMaker(String userpathfactored){
        StringBuilder factoredPath = new StringBuilder("");
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

    public static String pathFactorized(String solvedpath) {//errors here // straight path doesn't work // last f is being cut off
        StringBuilder factoredPath = new StringBuilder();
        int numOfTimes = 1;
        for (int index = 0;  index < solvedpath.length(); index++) {
            try {
                currentChar = solvedpath.charAt(index);
                nextChar = solvedpath.charAt(index + 1);
            } catch (IndexOutOfBoundsException e) {
                nextChar = 'N';
            }//out of index error for last char in string
            if (currentChar == nextChar) {
                numOfTimes++;
            }
            else  {
                if (numOfTimes >= 2) {
                    factoredPath.append(numOfTimes);
                }
                factoredPath.append(currentChar);
                factoredPath.append(" ");
                numOfTimes = 1;
            }
            currentChar = nextChar;
        }
        return factoredPath.toString();
    }
    public static void printPath(String solvedPath) {
        System.out.println(solvedPath);
    }
    public static void pathResult(boolean result) {
        if (result) {System.out.println("Correct Path");return;}
        System.out.println("Incorrect Path");
    }
}
