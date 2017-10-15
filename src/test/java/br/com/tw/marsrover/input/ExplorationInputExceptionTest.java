package br.com.tw.marsrover.input;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExplorationInputExceptionTest {

    @Test
    public void shouldCreateExceptionWithCorrectMessage() throws Exception {
        Exception exception = new Exception();
        String expectedMessage = "Não foi possível ler o arquivo X";

        ExplorationInputException explorationInputException = new ExplorationInputException(expectedMessage, exception);

        assertEquals(expectedMessage, explorationInputException.getMessage());
    }

}