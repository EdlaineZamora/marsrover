package br.com.tw.marsrover.exploration;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void createsPositionFromExplorationPlanCordinates() throws Exception {
        Position expectedPosition = new Position("2 2");

        Position position = new Position("2 2");

        assertEquals(expectedPosition, position);
    }

}