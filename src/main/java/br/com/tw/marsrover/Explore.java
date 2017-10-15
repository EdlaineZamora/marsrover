package br.com.tw.marsrover;

import br.com.tw.marsrover.exploration.Plan;
import br.com.tw.marsrover.input.ExplorationInput;
import br.com.tw.marsrover.input.ReadFileException;

import java.util.List;
import java.util.Scanner;

public class Explore {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path and filename of the Mars Exploration Plan (Example: /filePath/filename): ");
        String filePath = scanner.next();

        try {
            ExplorationInput explorationInput = new ExplorationInput(filePath);
            List<String> lines = explorationInput.extractLinesFromInputFile();
            Plan plan = new Plan(lines);
            plan.explore();

        } catch (ReadFileException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
