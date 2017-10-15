package br.com.tw.marsrover.exploration.rover;

public enum CardinalPoint {

    N,
    L,
    S,
    O;

    public static CardinalPoint nextCardinalPoint(CardinalPoint cardinalPoint, String[] moviments) {
        String direction = moviments[0];
        if ("R".equals(direction)) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i] == cardinalPoint) {
                    return values()[i+1];
                }
            }
        }
        return cardinalPoint;
    }

}
