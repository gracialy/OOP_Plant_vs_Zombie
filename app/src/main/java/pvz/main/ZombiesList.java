package pvz.main;

import java.util.Scanner;

public class ZombiesList implements Option {
    @Override
    public void select() {
        Scanner scanner = ScannerUtil.getScanner();
        int choice = -1;

        do {
            System.out.println("Michael List: ");
            System.out.println("Choose Michael's number to see the details: ");
            System.out.println("===============================");
            System.out.println("1. Normal Zombie");
            System.out.println("2. Conehead Zombie");
            System.out.println("3. Pole Vauting Zombie");
            System.out.println("4. Buckethead Zombie");
            System.out.println("5. Ducky Tube Zombie");
            System.out.println("6. Dolphin Rider Zombie");
            System.out.println("7. Digger Zombie");
            System.out.println("8. Flag Zombie");
            System.out.println("9. Ladder Zombie");
            System.out.println("10. Newspaper Zombie");
            System.out.println("0. Go Back");
            System.out.println("===============================");
            System.out.println("Enter your choice [0..10]:");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Normal Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 125");
                    System.out.println("Attack: 100");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 2:
                    System.out.println("Conehead Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 250");
                    System.out.println("Attack: 100");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 3:
                    System.out.println("Pole Vauting Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 175");
                    System.out.println("Attack: 100");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 4:
                    System.out.println("Buckethead Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 300");
                    System.out.println("Attack: 100");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 5:
                    System.out.println("Ducky Tube Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 100");
                    System.out.println("Attack: 100");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 6:
                    System.out.println("Dolphin Rider Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 175");
                    System.out.println("Attack: 100");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 7:
                    System.out.println("Digger Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 250");
                    System.out.println("Attack: 840");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 8:
                    System.out.println("Flag Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 250");
                    System.out.println("Attack: 200");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 9:
                    System.out.println("Ladder Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 250");
                    System.out.println("Attack: 840");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 10:
                    System.out.println("Newspaper Zombie");
                    System.out.println("===============================");
                    System.out.println("Health: 250");
                    System.out.println("Attack: 420");
                    System.out.println("Speed: 1");
                    System.out.println("===============================");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println("Enter anything to go back to the list: ");
            scanner.nextLine();
        }
        while (choice != 0);
    }
}
