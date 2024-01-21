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
        int argsP = 0;
        if ("-i".equals(args[0]) || "--input".equals(args[0])) {
            logger.info("**** Reading the maze from file " + args[1]);
            try {
                Maze.mazeMaker(args[1]);
            } catch (IOException e) {
                logger.error("Wrong maze file name\n");
                logger.error("Program will not produce a correct output");
            }
        }
        try {

            if ("-p".equals(args[2])) {
                String userPath = Print.pathCanonicalMaker(args[3]);
                boolean result = Path.pathCheck(userPath);
                Print.pathResult(result);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.info("No path given");
            argsP = 1;
        }
        try {
            if (argsP == 1) {
                logger.info("**** Computing path");
                String solvedPath = Path.pathFinder(args[1]);
                solvedPath = Print.pathFactorized(solvedPath);
                Print.printPath(solvedPath);
            }
        } catch (Exception e) {
                logger.error("PATH NOT COMPUTED");
            }
        logger.info("** End of MazeRunner");
    }
}

