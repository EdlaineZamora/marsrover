package br.com.tw.marsrover.exploration.rover;

import br.com.tw.marsrover.exploration.Position;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Rover {

    private final Position position;
    private final CardinalPoint cardinalPoint;
    private final List<Moviment> moviments;

    public Rover(Position position, CardinalPoint cardinalPoint, List<Moviment> moviments) {
        this.position = position;
        this.cardinalPoint = cardinalPoint;
        this.moviments = moviments;
    }

    public Rover move() {
        Position actualPosition = position;
        CardinalPoint actualCardinalPoint = cardinalPoint;

        for (Moviment moviment : moviments) {
            if (!moviment.isEmpty()) {
                actualCardinalPoint = CardinalPoint.nextCardinalPoint(actualCardinalPoint, asList(moviment));
            }
            if (CardinalPoint.N.equals(actualCardinalPoint)) {
                actualPosition = actualPosition.moveHeightMore(moviment.quantity());
            }
            if (CardinalPoint.E.equals(actualCardinalPoint)) {
                actualPosition = actualPosition.moveWidthMore(moviment.quantity());
            }
            if (CardinalPoint.S.equals(actualCardinalPoint)) {
                actualPosition = actualPosition.moveHeightMinus(moviment.quantity());
            }
            if (CardinalPoint.W.equals(actualCardinalPoint)) {
                actualPosition = actualPosition.moveWidthMinus(moviment.quantity());
            }
        }
        return new Rover(actualPosition, actualCardinalPoint, Collections.emptyList());
    }

    public Position initialPosition() {
        return position;
    }

    public CardinalPoint cardinalPoint() {
        return cardinalPoint;
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
        if (cardinalPoint != rover.cardinalPoint) return false;
        return moviments != null ? moviments.equals(rover.moviments) : rover.moviments == null;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (cardinalPoint != null ? cardinalPoint.hashCode() : 0);
        result = 31 * result + (moviments != null ? moviments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return position.toString() + " " + cardinalPoint.name();
    }

}
