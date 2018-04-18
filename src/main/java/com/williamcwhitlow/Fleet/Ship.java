package main.java.com.williamcwhitlow.Fleet;

/**
 * Contains definitions for properties and methods that are inherent to all the ship types.
 */
public interface Ship {

    /**
     * Checks the current status of the ship
     *
     * @return true if ship has been sunk
     */
    boolean isSunk();

    /**
     * Identifies if a ship has been placed
     *
     * @return true is ship has been assigned a slot
     */
    boolean isPlaced();

    /**
     * Used for storing the necessary information to define the space that a ship occupies.
     */
    void setPlacement();

    /**
     * Subtracts a Hit Point upon a successful strike.
     */
    void hitRegistered();
}
