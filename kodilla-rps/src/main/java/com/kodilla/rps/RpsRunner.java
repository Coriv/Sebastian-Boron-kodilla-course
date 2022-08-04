package com.kodilla.rps;
import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        RpsRunner.game();
    }

    public static void game() {
        System.out.println("Hey! Let's play the game");
        System.out.println("What is your name?: ");
        boolean end = false;
        Scanner input = new Scanner(System.in);

        Player player1 = new Player(input.next());
        System.out.println("How many games to win?");
        int howMuch = input.nextInt();
        Game game = new Game(player1, howMuch);

        while (!end) {
            game.showMenu();
            String choise = input.next();

            switch (choise) {
                case "1":
                    game.action(new Rock());
                    break;
                case "2":
                    game.action(new Paper());
                    break;
                case "3":
                    game.action(new Scissors());
                    break;
                case "4" : game.action(new Lizard());
                    break;
                case "5" : game.action(new Spock());
                    break;
                case "x": {
                    System.out.println("Are you sure to close the game? y/n..");
                    String exitChoice = input.next();
                    switch(exitChoice){
                        case "y" : System.exit(0);
                        default: System.out.println("You will back to the game");
                    }
                }
                case "n":
                    System.out.println("Are you sure to start the new game? y/n..");
                    String newGameChoice = input.next();
                    switch(newGameChoice){
                        case "y" : RpsRunner.game();
                        default: System.out.println("You will back to the game");
                    }
                default:
                    System.out.println("Bad choice. make it again");
            }
            end = game.isGameOver();
        }
        while (true) {
            game.showGameOverMenu();
            String choise2 = input.next();
            switch (choise2) {
                case "x":
                    System.exit(0);
                case "n":
                    RpsRunner.game();
                default:
                    System.out.println("Bad choice. Make it again");
            }
        }
    }
}
