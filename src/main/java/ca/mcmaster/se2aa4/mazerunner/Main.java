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
    private static String userPathComp;

    public static void main(String[] args) {
        logger.info("Start of MazeRunner");
        try {
            Configuration config = configure(args);
            fileName = config.returnFileName();
            userPath = config.returnUserPath();
            try {
                Maze.mazeMaker(fileName);
                logger.info("Making Maze");
            } catch (Exception e) {
                logger.error("\nMaze maker error\n");
                logger.error("Check maze file path");
                System.exit(1);
            }
            if (config.returnPathGiven()) {
                logger.info("Checking user path");
                userPathComp = Print.pathCanonicalMaker(userPath);
                boolean result = Path.userCheck(userPathComp);
                Print.pathResult(result);
            } else {
                logger.info("Solving for path");
                String solvedPath = Explorer.pathFinder();
                solvedPath = Print.pathFactorized(solvedPath);
                Print.printPath(solvedPath);
            }
        } catch (Exception e) {
            logger.error("\nMajor Error has occured\n Check your command line input");
            e.printStackTrace();
            System.exit(1);
        }
        logger.info("End of MazeRunner");
    }
        private static class Configuration {
            private final boolean PathGiven;
            private final String FileName;
            private final String UserPath;
            public Configuration(String FileName, String UserPath, boolean PathGiven) {
                this.PathGiven = PathGiven;
                this.FileName = FileName;
                this.UserPath = UserPath;
            }
            public boolean returnPathGiven() {
                return PathGiven;
            }
            public String returnFileName() {
                return FileName;
            }
            public String returnUserPath() {
                return UserPath;
            }
        }
        private static Configuration configure(String[] args) throws ParseException {
            Options options = new Options();
            options.addOption("i", "input", true, "Input File path");
            options.addOption("p", "path", true, "Input User Path ");
            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = parser.parse(options, args);
            String FileName = cmd.getOptionValue("i");
            String UserPath = cmd.getOptionValue("p");
            return new Configuration(FileName, UserPath, cmd.hasOption("p"));
        }
}

