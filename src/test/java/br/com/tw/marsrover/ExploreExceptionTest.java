package br.com.tw.marsrover;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExploreExceptionTest {

    @Test
    public void shouldCreateACorrectErrorMessage() throws Exception {
        String expectedMessage = "Correct error message";
        ExploreException exploreException = new ExploreException(expectedMessage, new Exception());

        assertEquals(expectedMessage, exploreException.getMessage());
    }

}