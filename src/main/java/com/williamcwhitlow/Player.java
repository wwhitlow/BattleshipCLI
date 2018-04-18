package main.java.com.williamcwhitlow;

import main.java.com.williamcwhitlow.Fleet.AircraftCarrier;
import main.java.com.williamcwhitlow.Fleet.Battleship;
import main.java.com.williamcwhitlow.Fleet.Cruiser;
import main.java.com.williamcwhitlow.Fleet.Destroyer;
import main.java.com.williamcwhitlow.Fleet.Ship;
import main.java.com.williamcwhitlow.Fleet.Submarine;

import java.util.LinkedList;
import java.util.List;

/**
 * Contains data that is relevant to the player.
 *
 * Ships that the player has in their fleet
 * 1 Aircraft Carrier (5 Squares)
 * 1 Battleship (4 Squares)
 * 1 Cruiser (3 Squares)
 * 2 Destroyers (2 Squares)
 * 2 Submarines (1 Square)
 */
public class Player {

    private char[][] guessedGrid;
    private char[][] fleetGrid;
    private String[] letterGuide = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private List<Ship> fleet;
    private AircraftCarrier carrier;
    private Battleship battleship;
    private Cruiser cruiser;
    private Destroyer destroyer1;
    private Destroyer destroyer2;
    private Submarine sub1;
    private Submarine sub2;
    private int deployIndex = 0;
    private Ship shipToDeploy;


    public Player() {
        guessedGrid = new char[10][10];
        for (int i = 0; i < guessedGrid.length; i++) {
            for (int j = 0; j < guessedGrid[i].length; j++) {
                guessedGrid[i][j] = "O".charAt(0);
            }
        }

        fleetGrid = new char[10][10];
        for (int i = 0; i < fleetGrid.length; i++) {
            for (int j = 0; j < fleetGrid[i].length; j++) {
                fleetGrid[i][j] = "O".charAt(0);
            }
        }

        //Initialize the fleet
        carrier = new AircraftCarrier();
        battleship = new Battleship();
        cruiser = new Cruiser();
        destroyer1 = new Destroyer();
        destroyer2 = new Destroyer();
        sub1 = new Submarine();
        sub2 = new Submarine();

        //Add the fleet to a List for easy access
        fleet = new LinkedList<>();
        fleet.add(carrier);
        fleet.add(battleship);
        fleet.add(cruiser);
        fleet.add(destroyer1);
        fleet.add(destroyer2);
        fleet.add(sub1);
        fleet.add(sub2);
    }

    /**
     * Draws Grid representing players guesses.
     */
    public void drawGuessedGrid() {
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < guessedGrid.length; i++) {
            System.out.print(letterGuide[i] +  "| ");
            for (int j = 0; j < guessedGrid[i].length; j++) {
                System.out.print(guessedGrid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Draws Grid representing players fleet.
     */
    public void drawFleetGrid() {
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < fleetGrid.length; i++) {
            System.out.print(letterGuide[i] +  "| ");
            for (int j = 0; j < fleetGrid[i].length; j++) {
                System.out.print(fleetGrid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Outputs information about ships still needing deployment
     */
    public void fleetLeftToDeploy() {
        System.out.print("Ships left to place: ");
        for (Ship ship: fleet) {
            if (!ship.isPlaced()) {
                System.out.print(ship.toString() + ", ");
            }
        }
        shipToDeploy = fleet.get(deployIndex);
        System.out.println("\nAdmiral where do you want to deploy your "
                + shipToDeploy.toString() + "?");
        deployIndex++;
    }

    /**
     * Tests to see if there are still ships left to deploy
     *
     * @return false if there are ships left true otherwise
     */
    public boolean isAllPlaced() {
        for (Ship ship: fleet) {
            if (!ship.isPlaced()) {
                return false;
            }
        }
        return true;
    }
}
