package br.com.tw.marsrover.exploration.rover;

public class Moviment {

    private final String direction;
    private final int move;

    public Moviment(String moviment) {
        this.direction = moviment.split("")[0];
        this.move = moviment.split("").length -1;
    }

    public String direction() {
        return direction;
    }

    public int move() {
        return move;
    }

    public boolean isRight() {
        return "R".equals(direction);
    }

    public boolean isLeft() {
        return "L".equals(direction);
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
