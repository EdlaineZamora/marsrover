package br.com.tw.marsrover.exploration.rover;

import br.com.tw.marsrover.exploration.Position;

public class Rover {

    private final Position position;
    private final CardinalPoint cardinalPoint;
    private final String moviments;

    public Rover(Position position, CardinalPoint cardinalPoint, String moviments) {
        this.position = position;
        this.cardinalPoint = cardinalPoint;
        this.moviments = moviments;
    }

    public Rover move() {
        String[] moviments = this.moviments.split("");
        CardinalPoint cardinalPoint = CardinalPoint.nextCardinalPoint(this.cardinalPoint, moviments);
        Position position = new Position("1 0");

        return new Rover(position, cardinalPoint, "");
    }

    public Position initialPosition() {
        return position;
    }

    public CardinalPoint cardinalPoint() {
        return cardinalPoint;
    }

    public String moviments() {
        return moviments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rover rover = (Rover) o;

        if (position != null ? !position.equals(rover.position) : rover.position != null)
            return false;
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

}
