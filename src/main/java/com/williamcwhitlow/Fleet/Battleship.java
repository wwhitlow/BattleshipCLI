package main.java.com.williamcwhitlow.Fleet;

public class Battleship implements Ship {

    private int hp;
    private boolean placed;

    public Battleship() {
        hp = 4;
        placed = false;
    }

    @Override
    public boolean isSunk() {
        return hp == 0;
    }

    @Override
    public void setPlacement() {
        placed = true;
    }

    @Override
    public boolean isPlaced() {
        return placed;
    }

    @Override
    public void hitRegistered() {
        hp--;
    }

    @Override
    public String toString() {
        return "Battleship";
    }
}
