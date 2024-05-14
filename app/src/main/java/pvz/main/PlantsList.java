package pvz.main;

import java.util.Scanner;

public class PlantsList implements Option {
    @Override
    public void select() {
        Scanner scanner = ScannerUtil.getScanner();

        // give list of plants
        // give plants attributes
        System.out.println("Lalapan List: ");
        System.out.println("Choose Lalapan's number to see the details: ");
        System.out.println("===============================");
        // placeholder
        System.out.println("1. Sunflower");
        System.out.println("2. Peashooter");
        System.out.println("3. Wallnut");
        System.out.println("4. Snowpea");
        System.out.println("5. Lilypad");
        System.out.println("6. Chomper");
        System.out.println("7. Jalapeno");
        System.out.println("8. Spikeweed");
        System.out.println("9. twinSunflower");
        System.out.println("10. Sunflower");
        System.out.println("0. Go Back");
        System.out.println("===============================");
        System.out.print("Enter your choice [0..10]: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.println("SunFlower");
                System.out.println("Health: 100");
                System.out.println("Attack: 0");
                System.out.println("Speed: 0");
                break;
            case 2:
                System.out.println("Peashooter");
                System.out.println("Health: 100");
                System.out.println("Attack: 25");
                System.out.println("Speed: 4");
                break;
            case 3:
                System.out.println("Wallnut");
                System.out.println("Health: 1000");
                System.out.println("Attack: 0");
                System.out.println("Speed: 0");
                break;
            case 4:
                System.out.println("Snowpea");
                System.out.println("Health: 100");
                System.out.println("Attack: 25");
                System.out.println("Speed: 4");
                break;
            case 5:
                System.out.println("Lilypad");
                System.out.println("Health: 100");
                System.out.println("Attack: 0");
                System.out.println("Speed: 0");
                break;
            case 6:
                System.out.println("Chomper");
                System.out.println("Health: 175");
                System.out.println("Attack: 5000");
                System.out.println("Speed: 42");
                break;
            case 7:
                System.out.println("Jalapeno");
                System.out.println("Health: 999999");
                System.out.println("Attack: 1800");
                System.out.println("Speed: 35");
                break;
            case 8:
                System.out.println("Spikeweed");
                System.out.println("Health: 999999");
                System.out.println("Attack: 20");
                System.out.println("Speed: 1");
                break;
            case 9:
                System.out.println("twinSunflower");
                System.out.println("Health: 300");
                System.out.println("Attack: 0");
                System.out.println("Speed: 0");
                break;
            case 10:
                System.out.println("Sunflower");
                System.out.println("Health: 100");
                System.out.println("Attack: 10");
                System.out.println("Speed: 1");
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        System.out.println("\nPress Enter to go back to the menu...");
        scanner.nextLine();
    }
}
