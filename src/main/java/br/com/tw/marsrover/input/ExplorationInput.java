package br.com.tw.marsrover.input;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExplorationInput {

    private static final String COULD_NOT_READ_FILE = "Could not read file ";
    private final File file;

    public ExplorationInput(String filePath) {
        file = new File(filePath);
    }

    public List<String> extractLinesFromInputFile() throws ExplorationInputException {
        try {
            Path path = Paths.get(file.toURI());

            return Files.lines(path)
                    .collect(Collectors.toList());

        } catch (IOException exception) {
            throw new ExplorationInputException(createErrorMessage(), exception);
        }
    }

    private String createErrorMessage() {
        return COULD_NOT_READ_FILE.concat(file.getPath());
    }

}
