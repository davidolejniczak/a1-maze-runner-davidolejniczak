package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        try {
            if ("-i".equals(args[0]) || "--input".equals(args[0])) {
                logger.info("**** Reading the maze from file " + args[1]);
                BufferedReader reader = new BufferedReader(new FileReader(args[1]));
                String line;
                mazemaker(args[1]);
                while ((line = reader.readLine()) != null) {
                    for (int idx = 0; idx < line.length(); idx++) {
                        if (line.charAt(idx) == '#') {
                            System.out.print("WALL ");
                        } else if (line.charAt(idx) == ' ') {
                            System.out.print("PASS ");
                        }
                    }
                    System.out.print(System.lineSeparator());
                }
            }
            if ("-p".equals(args[2])) {
                String userpath = pathCanonicalMaker(args[3]);//code to input an factorized path from the command line to canonical
                pathCheck(userpath); //return if path is correct or not, add extra input that is the maze file or somthing that can repersent it

            }
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        if (!("-p".equals(args[2]))) {
            logger.info("**** Computing path");
            try {
                String solvedpath = pathFinder(args[1]);//return path in canonical form
                pathFactorizedPrinter(solvedpath); //prints path in factorized form
            } catch(Exception e) {
                logger.info("PATH NOT COMPUTED");
            }
            logger.info("** End of MazeRunner");
        }
    }

    public static void mazeMaker() {
        //take the input maze and create a matrix that will store the maze so that it can be used in other functions
    }
    public static void pathCheck(String userpath){
        //checks if user path will work in maze
        //prints result
    }

    public static String pathCanonicalMaker(String userpathfactored){
        //converts the users factored path to canonical path that the computer can use to check if its correct
    }

    public static String pathFinder(String filepath){
        //finds the correct path throw the maze using a right hand strat while recording all moves taken
    }

    public static void pathFactorizedPrinter(String solvedpath){
        //takes in the solved path for a maze in canonical form and converts it too factorized form
        //prints result
    }
}

