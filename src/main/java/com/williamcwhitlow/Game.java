package main.java.com.williamcwhitlow;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Handles the main game logic concerning player turns and setup of the board game
 */
public class Game {
    private static Player player;
    private static Player player1;
    private static Player player2;
    private static List<Player> players = new LinkedList<>();
    private static int gameState = 1;
    private static int player1or2 = 0;

    public static void main(String[] args) throws IOException {

        while (true) {
            switch (gameState) {
                //Exit game
                case 0: System.out.println("So long have a good day exiting now");
                        return;
                //Load game
                case 1: System.out.println("Time to setup the game board!\nPlayer 1 ready? (y/n)");

                        int val = System.in.read();
                        if (val == 121  || val == 89) {
                            gameState = 2;
                            player1 = new Player();
                            player2 = new Player();
                            players.add(player1);
                            players.add(player2);
                        }
                        break;
                //Player One places their ships
                case 2: System.out.println("Player 1 time to assemble your fleet");
                        gameState = 3;
                        break;
                //Output Player 1 Fleet Remaining Info
                case 3: player = players.get(player1or2);
                        if (player.isAllPlaced()) {
                            player1or2 = 1;
                            gameState = 5;
                        } else {
                            player.drawFleetGrid();
                            player.fleetLeftToDeploy();
                            gameState = 4;
                        }
                        break;
                //Place Ship
                case 4: System.out.println("\nSorry I haven't had time to finish the rest. If you want me to continue" +
                        " please send me a message and I will");
                        return;
                //Player Two places their ships
                case 5: System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("Player 2 time to assemble your fleet");
                        gameState = 3;
                        break;
                //Take a Guess
                case 6: player = players.get(player1or2);
                        if (player1or2 == 0) {
                            System.out.print("Player 1 take a guess: ");
                        } else {
                            System.out.print("Player 2 take a guess: ");
                        }
                        gameState = 7;
                        break;
                //Parse Guess Input and Update
                case 7: break;
            }
        }
    }
}
