package spel;

import java.util.Scanner;

public class RockPaperScissor {
    static Scanner sc = new Scanner(System.in);

    static Boolean exit = false;
    static String[] weapons = {"Rock", "Paper", "Scissor"};
    static String compWon = "Computer won";
    static String playWon = "Player won";
    static String compChoice = "Computers choice: ";
    static int playersScore;
    static int computersScore;

    public static void main(String[] args) {
        playOrNot();
    }

    private static void playOrNot() {
        System.out.println("Press 1 to play rock, paper, scissor, press 0 to exit");
        int playOrExit = sc.nextInt();
        sc.nextLine();
        if (playOrExit == 1) {
            game();
        } else if (playOrExit == 0) {
            exit = true;
            System.out.println("Terminating....");
        } else {
            System.out.println("Invalid option, try again");
            playOrNot();
        }
    }
    public static void game() {
        while (!exit) {
            int computerRandom = (int) (Math.random() * 3);
            String computersChoice = weapons[computerRandom];

            System.out.println("Rock, paper or scissor? Press 0 to exit");
            String rockPaperScissor = sc.next();
            if (rockPaperScissor.equalsIgnoreCase("0")) {
                exit = true;
                System.out.println("Terminating....");
            }
            else if (rockPaperScissor.equalsIgnoreCase(computersChoice)) {
                System.out.println(compChoice + computersChoice);
                System.out.println("Draw");
                printScore();
            }
            else if (rockPaperScissor.equalsIgnoreCase("rock") && computersChoice.equals("Paper")) {
                ifComputerWins(computersChoice);
            }
            else if (rockPaperScissor.equalsIgnoreCase("rock") && computersChoice.equals("Scissor")) {
                ifPlayerWins(computersChoice);
            }
            else if (rockPaperScissor.equalsIgnoreCase("paper") && computersChoice.equals("Rock")) {
                ifPlayerWins(computersChoice);
            }
            else if (rockPaperScissor.equalsIgnoreCase("paper") && computersChoice.equals("Scissor")) {
                ifComputerWins(computersChoice);
            }
            else if (rockPaperScissor.equalsIgnoreCase("scissor") && computersChoice.equals("Rock")) {
                ifComputerWins(computersChoice);
            }
            else if (rockPaperScissor.equalsIgnoreCase("scissor") && computersChoice.equals("Paper")) {
                ifPlayerWins(computersChoice);
            }
            else {
                System.out.println("Wrong input, try again");
                game();
            }
        }
    }

    private static void presentWinner() {
        if (playersScore == 3) {
            System.out.println("*** Player won this round! ***");
            exit = true;
        } else if (computersScore == 3) {
            System.out.println("*** Computer won this round! ***");
            exit = true;
        }
    }

    private static void ifComputerWins(String computersChoice) {
        System.out.println(compChoice + computersChoice);
        System.out.println(compWon);
        computersScore++;
        printScore();
        presentWinner();

    }

    private static void printScore() {
        System.out.println("Computers total = " + computersScore + "\nPlayers total = " + playersScore);
    }

    private static void ifPlayerWins(String computersChoice) {
        System.out.println(compChoice + computersChoice);
        System.out.println(playWon);
        playersScore++;
        printScore();
        presentWinner();
    }
}
