package br.com.tw.marsrover.exploration;

import org.junit.Test;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.Assert.*;

public class ExplorationPlanTest {

    @Test
    public void createsHigherPositionFromInputLinesOfExplorationPlan() throws Exception {
        List<String> inputLines = singletonList("2 2");
        Position expectedPosition = new Position(inputLines.get(0));

        ExplorationPlan explorationPlan = new ExplorationPlan(inputLines);

        assertEquals(expectedPosition, explorationPlan.higherPosition());
    }


}