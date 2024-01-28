package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Print {
    private static char currentChar;
    private static char nextChar;
    private static char aheadChar;
    private static int numOfSpace;
    private static char nextMove;

    public static String pathFactorized(String solvedpath) {
        StringBuilder factoredPath = new StringBuilder();
        int numOfTimes = 1;
        for (int index = 0;  index < solvedpath.length(); index++) {
            try {
                currentChar = solvedpath.charAt(index);
                nextChar = solvedpath.charAt(index + 1);
            } catch (IndexOutOfBoundsException e) {
                nextChar = 'J';
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

    public static String pathCanonicalMaker(String userpathfactored) {
        StringBuilder canonicalPath = new StringBuilder();
        int count = 0;
        while (count < userpathfactored.length()) {
            currentChar = userpathfactored.charAt(count);
            if ('R' == currentChar || 'F' == currentChar || 'L' == currentChar) {
                canonicalPath.append(currentChar);
                count++;
            } else if (currentChar <= '9' && currentChar >= '0') {
                numOfSpace = Character.getNumericValue(currentChar);
                try {
                    nextMove = userpathfactored.charAt(count+1);
                } catch (Exception e) {//Checks if last char is a number
                    nextMove = '\0';
                    System.out.println("Incorrect Path");
                    System.out.println("Last char in path is a num");

                    System.exit(1);
                }
                if (nextMove <= '9' && nextMove >= '0') {
                    try {
                        aheadChar = nextMove;
                        nextMove = userpathfactored.charAt(count+2);
                    } catch (Exception e) {//Checks if last two chars are a number
                        nextMove = '\0';
                        System.out.println("Incorrect Path");
                        System.out.println("Last char in path is a num");
                        System.exit(1);
                    }
                    numOfSpace = (numOfSpace*10) + Character.getNumericValue(aheadChar);
                    count++;
                }
                for (int i = 0; i < numOfSpace; i++){
                    canonicalPath.append(nextMove);
                }
                count++;
                count++;
            } else {
                System.out.println("Incorrect Path");
                System.out.println("Random char in path");
                System.exit(1);//Checks for other chars in user path
            }
        }
        return canonicalPath.toString();
    }
}
