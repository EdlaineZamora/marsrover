package br.com.tw.marsrover;

import br.com.tw.marsrover.exploration.Plateau;
import br.com.tw.marsrover.exploration.rover.Rover;
import br.com.tw.marsrover.input.ExplorationInput;
import br.com.tw.marsrover.input.ExplorationInputException;

import java.util.List;
import java.util.Scanner;

public class Explore {

    public static void main(String... args) {
        String filePath = readFilePath();

        try {
            List<String> lines = extractLinesFromFile(filePath);

            List<Rover> rovers = explorePlateau(lines);

            printResultRovers(rovers);

        } catch (ExplorationInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static List<Rover> explorePlateau(List<String> lines) {
        Plateau plateau = new Plateau(lines);
        return plateau.explore();
    }

    private static List<String> extractLinesFromFile(String filePath) throws ExplorationInputException {
        ExplorationInput explorationInput = new ExplorationInput(filePath);
        return explorationInput.extractLinesFromInputFile();
    }

    private static void printResultRovers(List<Rover> rovers) {
        rovers.forEach(rover -> System.out.println(rover.toString()));
    }

    private static String readFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path and filename of the Mars Exploration Plateau (Example: /filePath/filename): ");
        return scanner.next();
    }

}
