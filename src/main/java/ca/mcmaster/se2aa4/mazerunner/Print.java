package src.main.java.ca.mcmaster.se2aa4.mazerunner;

public class Print {
    private static char currentChar;
    private static char nextChar;
    private static char aheadChar;

    public static String pathCanonicalMaker(String userpathfactored){
        StringBuilder factoredPath = new StringBuilder("");
        for (int index=0; index < userpathfactored.length();index++) {
            char currentChar = userpathfactored.charAt(index);
            try {
                aheadChar = (userpathfactored.charAt(index+1));
            } catch (Exception e) {
                aheadChar = currentChar;
            }
            if ("R".equals(currentChar) || "F".equals(currentChar) || "L".equals(currentChar)) {
                factoredPath.append((currentChar));
            } else if (currentChar >= '1' && aheadChar >= '0' && aheadChar <= '9') { //max num can be 99 for program to work
                int numOfTimes = (currentChar - '0')*10;
                numOfTimes += userpathfactored.charAt(index+1) - '0';
                index++; index++;
                if ("R".equals(currentChar)) {
                    for (int n=0; n<numOfTimes; n++){
                        factoredPath.append(currentChar);
                    }
                }
                if ("F".equals(currentChar)) {
                    for (int n=0; n<numOfTimes; n++){
                        factoredPath.append(currentChar);
                    }
                }
                if ("L".equals(currentChar)) {
                    for (int n=0; n<numOfTimes; n++){
                        factoredPath.append(currentChar);
                    }
                }
                index++;
            } else if ((currentChar <= '9' && currentChar >= '0')) {
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
}

//FR6F2L8FR2FR2F2L2FR2FR4FR2FL4FL2F2L2FR4FR2FL2FR2FR4FR2F2L2FL2FR2FR4FR2F2L2FL2FR2F2L2FR2FR2F2L4FR2FR2F2L4FR2FR2F2L4FR2FR2F2L2FR10FR2FR8F2L8FL2FR4FR2FR2F2L2FR2FR14F2L12FR2FR6F2L4FR2FR6FR2FL6F2L6FR2FR8F2L12FR2FR10F2L6FR2FR4F2L4FL2FR4FL2FR2FL2FR2FL2FR2FL4FR2FR2F2L4FR2FR6FR2F2L2FR2FR4F2L2FR2FR4F2L4FR2FR2F2L2FR2FR4FR2FL2F2L2FR2FR6FL2FR8F2L8FR2FR10FR4FR2F2L2FR2F2L2FR2FR2FL4FR2F2L4F2L2FR4FR2FR2F2L4FR2FR6F2L6FR4FR2FR2FL2F2L2FR4FR2FR2F2L2FR2FR4F2L4FL4FR2FR4F2L2FR2F2L2FR2FR2F2L6FR2FR8FR6FR2F2L2FL2FRF
