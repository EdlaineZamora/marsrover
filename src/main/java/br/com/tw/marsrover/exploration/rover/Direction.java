package br.com.tw.marsrover.exploration.rover;

import java.util.List;

public enum Direction {

    N, E, S, W;

    public static final int LAST_CARDINAL_POINT = 3;
    public static final int FIRST_CARDINAL_POINT = 0;
    public static final String RIGHT = "R";
    public static final String EMPTY = "";

    public static Direction finalCardinalPointAfterCommands(Direction cardinalPoint, List<Moviment> moviments) {
        Direction directionFound = cardinalPoint;

        for (Moviment moviment : moviments) {
            String[] direction = moviment.direction().split(EMPTY);
            for (int i = 0; i < direction.length; i++) {
                if (direction[i].equals(RIGHT)) {
                    directionFound = nextCardinalPointForRightDirection(directionFound);
                } else {
                    directionFound = nextCardinalPointForLeftDirection(directionFound);
                }
            }
        }

        return directionFound;
    }

    private static Direction nextCardinalPointForLeftDirection(Direction directionFound) {
        if (directionFound.ordinal() == FIRST_CARDINAL_POINT) {
            return W;
        }
        return values()[directionFound.ordinal() - 1];
    }

    private static Direction nextCardinalPointForRightDirection(Direction directionFound) {
        if (directionFound.ordinal() == LAST_CARDINAL_POINT) {
            return N;
        }
        return values()[directionFound.ordinal() + 1];
    }

}
