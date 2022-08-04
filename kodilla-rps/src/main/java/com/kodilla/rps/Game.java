package com.kodilla.rps;
public class Game {
    private Player player;
    private int playerPoints;
    private int compPoints;
    private int lengthOfTheGame;
    private boolean gameOver = false;
    private String[] rps = {"Rock", "Paper", "Scissor", "Lizard", "Spock"};
    private int[] rpsValue = {0,1, 2, 3, 4};
    public Game(Player player,int lengthOfTheGame) {
        this.player = player;
        this.lengthOfTheGame = lengthOfTheGame;
    }

    public void showMenu() {
        System.out.println("\nMake a choice");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissor");
        System.out.println("4. Lizard");
        System.out.println("5. Spock");
        System.out.println("x. Exit");
        System.out.println("n. Start New Game");
    }

    public void showGameOverMenu() {
        System.out.println("\nHey, game is over! Make a choice what would you like to do now: ");
        System.out.println("x. Exit");
        System.out.println("n. Start New Game");
    }

    public void action(Move move) {
        int rand = (int) (Math.random() * rpsValue.length);
        int value = move.getValue();
        System.out.println("\nChoice of player " + player.getName() + ": " + rps[value]);
        System.out.println("Choice of computer: " + rps[rand]);

        if(value == rand) {
            System.out.println("Equal result. No points.");
        }
        if(value == 0 && rand == rpsValue[2]) {
            playerPoints++;
            System.out.println("\nPoint for player " + player.getName());
        }
        if(value == 0 && rand ==rpsValue[1] ) {
            compPoints++;
            System.out.println("\nPoint for computer ");
        }
        if(value == 1 && rand == rpsValue[0] ) {
            playerPoints++;
            System.out.println("\nPoint for player " + player.getName());
        }
        if(value == 1 && rand == rpsValue[2] ) {
            compPoints++;
            System.out.println("\nPoint for computer");
        }
        if(value == 1 && rand == rpsValue[4] ) {
            playerPoints++;
            System.out.println("\nPoint for computer");
        }
        if(value == 2 && rand == rpsValue[3] ) {
            playerPoints++;
            System.out.println("\nPoint for player " + player.getName());
        }
        if(value == 2 && rand ==rpsValue[1]) {
            playerPoints++;
            System.out.println("\nPoint for player " + player.getName());
        }
        if(value == 2 && rand == rpsValue[0] ) {
            compPoints++;
            System.out.println("\nPoint for computer");
        }
        if(value == 3 && rand == rpsValue[0] ) {
            compPoints++;
            System.out.println("\nPoint for computer");
        }
        if(value == 3 && rand == rpsValue[4] ) {
            playerPoints++;
            System.out.println("\nPoint for player " + player.getName());
        }
        if(value == 3 && rand == rpsValue[1] ) {
            playerPoints++;
            System.out.println("\nPoint for player " + player.getName());
        }
        if(value == 4 && rand == rpsValue[2] ) {
            playerPoints++;
            System.out.println("\nPoint for player " + player.getName());
        }
        if(value == 4 && rand == rpsValue[0] ) {
            playerPoints++;
            System.out.println("\nPoint for player " + player.getName());
        }

        System.out.println("Currently result: " + player.getName() + " " + getPlayerPoints() + ":" + getCompPoints() + " Computer");
        System.out.println("Number of point to win: " + getLengthOfTheGame());

        if (compPoints == getLengthOfTheGame()) {
            System.out.println("\nGave over! Computer win");
            gameOver = true;
        }

        if (playerPoints == getLengthOfTheGame()) {
            System.out.println("\nCongratulation " + player.getName() + ", you won!");
            gameOver = true;
        }

    }

    public Player getPlayer() {
        return player;
    }

    public int getPlayerPoints() {
        return playerPoints;
    }

    public int getCompPoints() {
        return compPoints;
    }

    public int getLengthOfTheGame() {
        return lengthOfTheGame;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
