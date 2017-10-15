package br.com.tw.marsrover;

import br.com.tw.marsrover.exploration.Plateau;
import br.com.tw.marsrover.input.ExplorationInput;
import br.com.tw.marsrover.input.ExplorationInputException;

import java.util.List;
import java.util.Scanner;

public class Explore {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path and filename of the Mars Exploration Plateau (Example: /filePath/filename): ");
        String filePath = scanner.next();

        try {
            ExplorationInput explorationInput = new ExplorationInput(filePath);
            List<String> lines = explorationInput.extractLinesFromInputFile();
            Plateau plateau = new Plateau(lines);
            plateau.explore();

        } catch (ExplorationInputException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
