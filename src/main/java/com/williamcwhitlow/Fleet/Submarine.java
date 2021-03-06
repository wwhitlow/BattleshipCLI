package main.java.com.williamcwhitlow.Fleet;

public class Submarine implements Ship {

    private int hp;
    private boolean placed;

    public Submarine() {
        hp = 1;
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
        return "Submarine";
    }
}
