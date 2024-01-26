package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Print {
    private static char currentChar;
    private static char currentCharWithIndex;

    public static String pathCanonicalMaker(String userpathfactored){
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
        StringBuilder factoredPath = new StringBuilder();
        factoredPath.append("");
        for (int index = 0;  index < solvedpath.length(); index++) {
            int numOfTimes = 1;
            try {
                currentChar = solvedpath.charAt(index);
                currentCharWithIndex = solvedpath.charAt(index + 1);
            } catch (IndexOutOfBoundsException e){}//out of index error for last char in string
            if (index < solvedpath.length()-1 && currentChar == currentCharWithIndex) {
                char aheadChars = solvedpath.charAt(index+numOfTimes);
                while (currentChar == aheadChars) {
                    numOfTimes++; index++;
                    try {
                        aheadChars = solvedpath.charAt(index+numOfTimes);
                    } catch (IndexOutOfBoundsException e) {//out of index error if double is last thing in string
                        break;
                    }
                }
                if (numOfTimes >= 2) {index++;numOfTimes++;}//to account for the last match
                String numOfTimesString = Integer.toString(numOfTimes);
                factoredPath.append(numOfTimesString);
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
