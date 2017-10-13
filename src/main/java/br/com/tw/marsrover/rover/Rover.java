package br.com.tw.marsrover.rover;

import br.com.tw.marsrover.exploration.Position;

public class Rover {

    private final Position initialPosition;
    private final String initialCardinalPoint;
    private final String moviments;

    public Rover(Position initialPosition, String initialCardinalPoint, String moviments) {
        this.initialPosition = initialPosition;
        this.initialCardinalPoint = initialCardinalPoint;
        this.moviments = moviments;
    }

    public Position initialPosition() {
        return initialPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (initialPosition != null ? !initialPosition.equals(rover.initialPosition) : rover.initialPosition != null)
            return false;
        if (initialCardinalPoint != null ? !initialCardinalPoint.equals(rover.initialCardinalPoint) : rover.initialCardinalPoint != null)
            return false;
        return moviments != null ? moviments.equals(rover.moviments) : rover.moviments == null;
    }

    @Override
    public int hashCode() {
        int result = initialPosition != null ? initialPosition.hashCode() : 0;
        result = 31 * result + (initialCardinalPoint != null ? initialCardinalPoint.hashCode() : 0);
        result = 31 * result + (moviments != null ? moviments.hashCode() : 0);
        return result;
    }
}
