package pl.honestit.coderslab.workshops.consoleapps;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    public static void main(String[] args) {

        printWelcomeMessage();
        while (true) {
            showMenu();
            String userInput = getDecision();
            if (validAction(userInput)) {
                if (isExitAction(userInput)) {
                    exitAction();
                    break;
                }
                executeAction(userInput);
            }
        }
        printGoodbyeMessage();
    }

    private static void executeAction(String userInput) {
        String correctedInput = userInput.trim().toLowerCase();
        if ("1".equals(correctedInput)) {
            executeAction1();
        } else if ("2".equals(correctedInput)) {
            executeAction2();
        }
    }

    private static void executeAction2() {
        System.out.print("Podaj swoją ulubioną liczbę, ale taką jak moja: ");
        Random random = new Random();
        int favouriteNumber = 1 + random.nextInt(10);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int userGuess = scanner.nextInt();
            if (userGuess == favouriteNumber) {
                System.out.println("Zgadłeś mistrzu/mistrzyni!");
                break;
            } else {
                System.out.print("Zgaduj dalej: ");
            }
        }
    }

    private static void executeAction1() {
        System.out.println("Ratujesz świat!");
    }

    private static void printGoodbyeMessage() {
        System.out.println("Miło było Cię obsługiwać... ;( ");
    }

    private static void exitAction() {
        System.out.println("Kończę działanie...");
    }

    private static boolean isExitAction(String userInput) {
        return "3".equals(userInput.trim().toLowerCase());
    }

    private static boolean validAction(String userInput) {
        String correctInput = userInput.trim().toLowerCase();
        String[] validActions = {"1", "2", "3"};
        Arrays.sort(validActions); // Opcjonalne gdyby nie chciało nam się
        // wpisywać opcji w kolejności
        // alfanumerycznej
        int index = Arrays.binarySearch(validActions, correctInput);
        return index >= 0;
    }

    private static String getDecision() {
        System.out.print("Twój wybór: ");
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        return decision;
    }

    private static void showMenu() {
        System.out.println("Menu\n");
        System.out.println("(1) Nic");
        System.out.println("(2) Coś");
        System.out.println("(3) Zakończyć");
    }

    private static void printWelcomeMessage() {
        System.out.println("Witaj w naszej uniwersalnej aplikacji!");
    }
}
