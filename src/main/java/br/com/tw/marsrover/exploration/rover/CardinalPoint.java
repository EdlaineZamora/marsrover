package br.com.tw.marsrover.exploration.rover;

import java.util.List;

public enum CardinalPoint {

    N,
    L,
    S,
    O;

    public static CardinalPoint nextCardinalPoint(CardinalPoint cardinalPoint, List<String> moviments) {
        CardinalPoint finalCardinalPoint = cardinalPoint;

        for (String moviment : moviments) {
            if ("R".equals(moviment.toString().split("")[0])) {
                for (int i = 0; i < values().length; i++) {
                    if (values()[i] == cardinalPoint) {
                        finalCardinalPoint = values()[i+1];
                    }
                }
            } else {
                for (int i = 0; i < values().length; i++) {
                    if (values()[i] == cardinalPoint) {
                        if (i == 0) {
                            return values()[3];
                        }
                        return values()[i - 1];
                    }
                }
            }
        }
        return finalCardinalPoint;
    }

}
