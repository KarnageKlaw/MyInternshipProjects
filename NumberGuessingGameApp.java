import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            playGame();

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }

        } while (true);

        // Close the scanner
        scanner.close();
    }

    private static void playGame() {
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int userGuess;
        int attempts = 0;

        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");

        do {
            System.out.print("Enter your guess: ");
            userGuess = getUserInput();
            attempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
            }
        } while (userGuess != numberToGuess);
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int input = -1;

        while (true) {
            try {
                input = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        return input;
    }
}
