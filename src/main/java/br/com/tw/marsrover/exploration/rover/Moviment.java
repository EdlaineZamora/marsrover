package br.com.tw.marsrover.exploration.rover;

public class Moviment {

    public static final String ONLY_R_AND_L_PATTERN = "([R|L+])";
    public static final String ONLY_MOVE_PATTERN = "([M+])";
    private final String direction;
    private final int move;

    public Moviment(String moviment) {
        String[] moviments = moviment.split("");
        if (!moviments[0].matches(ONLY_R_AND_L_PATTERN)) {
            this.direction = "";
            this.move = extractMovesQuantity(moviment);
            return;
        }
        this.direction = moviment.replaceAll(ONLY_MOVE_PATTERN, "");
        this.move = extractMovesQuantity(moviment);
    }

    private int extractMovesQuantity(String moviment) {
        String moves = moviment.replaceAll(ONLY_R_AND_L_PATTERN, "");
        return moves.length();
    }

    public String direction() {
        return direction;
    }

    public int quantity() {
        return move;
    }

    public boolean isRight() {
        return direction.startsWith("R");
    }

    public boolean isLeft() {
        return "E".equals(direction);
    }

    public boolean isEmpty() {
        return direction.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Moviment moviment = (Moviment) o;

        if (move != moviment.move) return false;
        return direction != null ? direction.equals(moviment.direction) : moviment.direction == null;
    }

    @Override
    public int hashCode() {
        int result = direction != null ? direction.hashCode() : 0;
        result = 31 * result + move;
        return result;
    }

}
