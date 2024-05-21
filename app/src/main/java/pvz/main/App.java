package pvz.main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Loading Game");
        for (int i = 0; i < 3; i++) {
            System.out.print(" .");
            // ToolsUtil.delay(1);
        }
        System.out.println();

        Scanner scanner = ScannerUtil.getScanner();
        int choice = -1;

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
            System.out.println("Enter your choice [0..4]: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
                // ToolsUtil.delay(1);
                continue;
            }

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
                    System.out.print("Exiting Game");
                    for (int i = 0; i < 3; i++) {
                        System.out.print(" .");
                        // ToolsUtil.delay(1);
                    }
                    // ToolsUtil.delay(2);
                    ToolsUtil.clearScreen();
                    System.out.println("\nThank you for playing Michael vs. Lalapan!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    // ToolsUtil.delay(1);
                    break;
            }
        } while (choice != 0);

        ScannerUtil.getScanner().close();
    }
}
