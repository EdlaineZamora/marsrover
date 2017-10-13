package br.com.tw.marsrover;

import br.com.tw.marsrover.input.ExplorationInput;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExplorationInputTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldReturnThreeLinesFromAnInputOfOneRoverAndOneMove() throws Exception {
        String path = getPathFromFileName();

        ExplorationInput explorationInput = new ExplorationInput(path);
        List<String> lines = explorationInput.extractLinesFromInputFile();

        assertEquals(lines.size(), 3);
    }

    @Test
    public void shouldThrowsExceptionWhenCouldNotReadFile() throws Exception {
        expectedException.expectMessage("Could not read file exception");

        ExplorationInput explorationInput = new ExplorationInput("exception");
        explorationInput.extractLinesFromInputFile();
    }

    private String getPathFromFileName() {
        String fileName = "oneRoverWithOneMove";

        ClassLoader classLoader = getClass().getClassLoader();

        return classLoader.getResource(fileName).getPath();
    }

}