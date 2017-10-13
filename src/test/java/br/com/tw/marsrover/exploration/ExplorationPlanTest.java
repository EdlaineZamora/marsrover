package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.rover.Rover;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExplorationPlanTest {

    @Test
    public void createsHigherPositionFromInputLinesOfExplorationPlan() throws Exception {
        List<String> inputLines = createDefaultInputExplorationPlan();
        Position expectedPosition = new Position(inputLines.get(0));

        ExplorationPlan explorationPlan = new ExplorationPlan(inputLines);

        assertEquals(expectedPosition, explorationPlan.higherPosition());
    }

    @Test
    public void createOneRoverFromInputLinesOfExplorationPlan() throws Exception {
        List<String> inputLines = createDefaultInputExplorationPlan();
        Position initialPosition = new Position(inputLines.get(1));

        Rover expectedRover = new Rover(initialPosition, "N", "RM");

        ExplorationPlan explorationPlan = new ExplorationPlan(inputLines);

        assertEquals(expectedRover, explorationPlan.rovers().get(0));
    }

    private List<String> createDefaultInputExplorationPlan() {
        List<String> inputLines = new ArrayList<>();
        inputLines.add("2 2");
        inputLines.add("0 0 N");
        inputLines.add("RM");
        return inputLines;
    }

}