package main.java.com.williamcwhitlow.Fleet;

/**
 * Aircraft Carrier containing important status of a players Aircraft Carrier
 */
public class AircraftCarrier implements Ship {

    private int hp;
    private boolean placed;

    public AircraftCarrier() {
        hp = 5;
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
        return "Aircraft Carrier";
    }
}
