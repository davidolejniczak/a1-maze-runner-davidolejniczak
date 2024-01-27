package ca.mcmaster.se2aa4.mazerunner;
import org.apache.commons.cli.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import java.util.logging.ConsoleHandler;
import src.main.java.ca.mcmaster.se2aa4.mazerunner.Explorer;
import src.main.java.ca.mcmaster.se2aa4.mazerunner.Maze;
import src.main.java.ca.mcmaster.se2aa4.mazerunner.Path;
import src.main.java.ca.mcmaster.se2aa4.mazerunner.Print;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static String fileName;
    private static String userPath;

    public static void main(String[] args) {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("i", "input", true, "Getting input file");
        options.addOption("p", "path", true, "Getting user given path");
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("i")) {
                fileName = cmd.getOptionValue("i");
                try {
                    Maze.mazeMaker(fileName);
                }catch (Exception e) {
                    logger.error("Maze maker error\n");
                    logger.error("Check maze file path");
                    System.exit(1);
                }
            }
            if (cmd.hasOption("p")) {
                userPath = cmd.getOptionValue("p");
                String userPathComp = Print.pathCanonicalMaker(userPath);
                boolean result = Path.userCheck(userPathComp);
                Print.pathResult(result);
            } else {
                String solvedPath = Explorer.pathFinder();
                solvedPath = Print.pathFactorized(solvedPath);
                Print.printPath(solvedPath);
            }

        } catch (Exception e) {
            logger.error("Major Error has occured");
        }
    }
}


