package br.com.tw.marsrover.exploration.rover;

import br.com.tw.marsrover.exploration.Position;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Rover {

    private final Position position;
    private final Direction direction;
    private final List<Moviment> moviments;

    public Rover(Position position, Direction direction, List<Moviment> moviments) {
        this.position = position;
        this.direction = direction;
        this.moviments = moviments;
    }

    public Rover move() {
        Position actualPosition = position;
        Direction actualDirection = direction;

        for (Moviment moviment : moviments) {
            actualDirection = calculateNewDirection(actualDirection, moviment);
            actualPosition = calculateNewPosition(actualPosition, actualDirection, moviment);
        }
        return new Rover(actualPosition, actualDirection, Collections.emptyList());
    }

    private Direction calculateNewDirection(Direction actualDirection, Moviment moviment) {
        if (!moviment.isEmpty()) {
            actualDirection = Direction.finalCardinalPointAfterCommands(actualDirection, asList(moviment));
        }
        return actualDirection;
    }

    private Position calculateNewPosition(Position actualPosition, Direction actualDirection, Moviment moviment) {
        int numberOfSteps = moviment.quantity();
        if (isCardinalPointNorth(actualDirection)) {
            return actualPosition.moveHeightMore(numberOfSteps);
        }
        if (isCardinalPointEast(actualDirection)) {
            return actualPosition.moveWidthMore(numberOfSteps);
        }
        if (isCardinalPointSouth(actualDirection)) {
            return actualPosition.moveHeightMinus(numberOfSteps);
        }
        if (isCardinalPointWest(actualDirection)) {
            return actualPosition.moveWidthMinus(numberOfSteps);
        }
        return actualPosition;
    }

    private boolean isCardinalPointWest(Direction actualDirection) {
        return Direction.W.equals(actualDirection);
    }

    private boolean isCardinalPointSouth(Direction actualDirection) {
        return Direction.S.equals(actualDirection);
    }

    private boolean isCardinalPointEast(Direction actualDirection) {
        return Direction.E.equals(actualDirection);
    }

    private boolean isCardinalPointNorth(Direction actualDirection) {
        return Direction.N.equals(actualDirection);
    }

    public Position initialPosition() {
        return position;
    }

    public Direction cardinalPoint() {
        return direction;
    }

    public List<Moviment> moviments() {
        return moviments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (position != null ? !position.equals(rover.position) : rover.position != null) return false;
        if (direction != rover.direction) return false;
        return moviments != null ? moviments.equals(rover.moviments) : rover.moviments == null;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (moviments != null ? moviments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return position.toString() + " " + direction.name();
    }

}
