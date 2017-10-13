package br.com.tw.marsrover.exploration;

import br.com.tw.marsrover.rover.Rover;

import java.util.List;

public class ExplorationPlan {

    private final Position higherPosition;
    private final RoverCollection rovers;

    public ExplorationPlan(List<String> inputLines) {
        higherPosition = new Position(inputLines.get(0));
        inputLines.remove(0);
        rovers = new RoverCollection(inputLines);
    }

    public void explore() {

    }

    public Position higherPosition() {
        return higherPosition;
    }

    public List<Rover> rovers() {
        return rovers.rovers();
    }

}
