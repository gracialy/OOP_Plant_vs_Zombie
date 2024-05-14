package pvz.main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Loading Game");
        for (int i = 0; i < 3; i++) {
            System.out.print(" .");
            ToolsUtil.delay(1);
        }
        System.out.println();

        Scanner scanner = ScannerUtil.getScanner();
        int choice = -1;
        // IMPORTANT: HANDLE ILLEGAL INPUT LIKE \n OR OUT OF RANGE

        do {
            ToolsUtil.clearScreen();
            System.out.println("Welcome to Michael vs. Lalapan!");
            System.out.println("===============================");
            System.out.println("1. Start Game");
            System.out.println("2. Help");
            System.out.println("3. Michael List");
            System.out.println("4. Lalapan List");
            System.out.println("0. Exit");
            System.out.println("===============================");
            System.out.print("Enter your choice [0..4]: ");
            choice = Integer.parseInt(scanner.nextLine());

            ToolsUtil.clearScreen();
            switch (choice) {
                case 1:
                    Option start = new Start();
                    start.select();
                    break;
                case 2:
                    Option help = new Help();
                    help.select();
                    break;
                case 3:
                    Option michaelList = new ZombiesList();
                    michaelList.select();
                    break;
                case 4:
                    Option lalapanList = new PlantsList();
                    lalapanList.select();
                    break;
                case 0:
                    System.out.print("Exiting Game . . .");
                    ToolsUtil.delay(2);
                    ToolsUtil.clearScreen();
                    System.out.println("\nThank you for playing Michael vs. Lalapan!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        ScannerUtil.getScanner().close();
    }
}
