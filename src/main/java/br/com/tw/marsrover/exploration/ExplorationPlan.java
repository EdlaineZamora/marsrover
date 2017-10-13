package br.com.tw.marsrover.exploration;

import java.util.List;

public class ExplorationPlan {

    private final Position higherPosition;

    public ExplorationPlan(List<String> inputLines) {
        higherPosition = new Position(inputLines.get(0));
    }

    public void explore() {

    }

    public Position higherPosition() {
        return higherPosition;
    }

}
