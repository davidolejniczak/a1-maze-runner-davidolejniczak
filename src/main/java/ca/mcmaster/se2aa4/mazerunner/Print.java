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
        //System.out.println("BEFORE WHILE LOOP ");
        while (count < userpathfactored.length()) {
            //System.out.println("TOP OF WHILE LOOP + INDEX: " + count);
            currentChar = userpathfactored.charAt(count);
            //System.out.println("WHAT IS THE CURRENT CHAR: "+currentChar);
            if ('R' == currentChar || 'F' == currentChar || 'L' == currentChar) {
                canonicalPath.append(currentChar);
                count++;
            } else if (currentChar <= '9' && currentChar >= '0') {
                //System.out.println("TOP OF ELSE IF STATMENT");
                numOfSpace = Character.getNumericValue(currentChar);
                //System.out.println("NUM OF SPACE: "+numOfSpace);
                try {
                    nextMove = userpathfactored.charAt(count+1);
                } catch (Exception e) {//Checks if last char is a number
                    nextMove = '\0';
                    System.out.println("Error Last char in path is a num");
                    System.out.println("Check path input");
                    System.exit(1);
                }
                //System.out.println("AHEAD CHAR : " +nextMove);
                if (nextMove <= '9' && nextMove >= '0') {
                    //System.out.println("TOP OF IF IN ELSE IF ");
                    try {
                        aheadChar = nextMove;
                        nextMove = userpathfactored.charAt(count+2);
                    } catch (Exception e) {//Checks if last two chars are a number
                        nextMove = '\0';
                        System.out.println("Error Last char in path is a num");
                        System.out.println("Check path input");
                        System.exit(1);
                    }
                    numOfSpace = (numOfSpace*10) + Character.getNumericValue(aheadChar);
                    count++;
                    //System.out.println("NUM OF CHARS: "+numOfSpace);
                }
                //System.out.println("TOP OF FOR LOOP ");
                for (int i = 0; i < numOfSpace; i++){
                    canonicalPath.append(nextMove);
                    //System.out.println("IN FOR LOOP");
                }
                //System.out.println("BEFORE COUNT ++");
                count++;
                count++;
            } else {
                System.out.println("Incorrect Path");
                System.out.println("Random char in path");
                System.exit(1);//for other chars that somehow got in
            }
        }
        //System.out.println("RIGHT BEFOR RETURN");
        return canonicalPath.toString();
    }


}

//5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F
//public static String pathCanonicalMaker(String userpathfactored){
//    StringBuilder factoredPath = new StringBuilder();
//    int index = 0;
//    while(index < userpathfactored.length()) {
//        //System.out.println(index + " INDEX CURRENT");
//        currentChar = userpathfactored.charAt(index);
//        //System.out.println(currentChar + "CURRENT CHAR STAART");
//        try {
//            aheadChar = (userpathfactored.charAt(index+1));
//        } catch (Exception e) {
//            aheadChar = '\0';
//        }
//        try {
//            aheadby2Char = (userpathfactored.charAt(index + 2));
//        } catch (Exception e) {
//            aheadby2Char = '\0';
//        }
//        if ('R' == currentChar || 'F' == currentChar || 'L' == currentChar) {
//            factoredPath.append((currentChar));
//            index++;
//        } else if ((currentChar <= '9' && currentChar >= '0')) {
//            //System.out.println("YOU SHOULD BE HERE ");
//            nextMoveType = aheadChar;
//            numOfSpace = Character.getNumericValue(currentChar);
//            index++;
//            if (aheadChar <= '9' && aheadChar >= '0') {
//                numOfSpace = (numOfSpace * 10) + Character.getNumericValue(aheadChar);
//                //System.out.println("NUM NOT TOO FAR ADDED");
//                index++;
//                nextMoveType = aheadby2Char;
//            }
//            if ('R' == nextMoveType) {
//                for (int n=0; n<numOfSpace; n++){
//                    factoredPath.append(nextMoveType);
//                }
//            }
//            if ('F' == nextMoveType) {
//                for (int n=0; n<numOfSpace; n++){
//                    factoredPath.append(nextMoveType);
//                    //System.out.println("YOU MOVE F");
//                }
//            }
//            if ('L' == nextMoveType) {
//                for (int n=0; n<numOfSpace; n++){
//                    factoredPath.append(nextMoveType);
//                }
//            }
//        } else {
//            index ++;
//        }
//        index++;
//        //System.out.println("BEFORE current Char");
//        //System.out.println(currentChar);
//    }
//    return factoredPath.toString();
//}
