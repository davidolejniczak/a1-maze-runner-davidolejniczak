package ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import src.main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import src.main.java.ca.mcmaster.se2aa4.mazerunner.Path;
import src.main.java.ca.mcmaster.se2aa4.mazerunner.Print;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");
        if ("-i".equals(args[0]) || "--input".equals(args[0])) {
            logger.info("**** Reading the maze from file " + args[1]);
            try {
                Maze.mazeMaker(args[1]);
            } catch (IOException e) {
                logger.error("Wrong maze file name");
                System.exit(1);
            }
        }
        try {
            if ("-p".equals(args[2])) {
                String userpath = Print.pathCanonicalMaker(args[3]);//code to input an factorized path from the command line to canonical
                Path.pathCheck(userpath); //return if path is correct or not, add extra input that is the maze file or somthing that can repersent it
            }
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("/!\\ No -p args /!\\");
        }
        try {
            if (!("-p".equals(args[2]))) {
                logger.info("**** Computing path");
                String solvedpath = Path.pathFinder(args[1]);//return path in canonical form
                Print.pathFactorizedPrinter(solvedpath); //prints path in factorized form
            }
        } catch (Exception e) {
                logger.info("PATH NOT COMPUTED");
            }
            logger.info("** End of MazeRunner");
        }
}

