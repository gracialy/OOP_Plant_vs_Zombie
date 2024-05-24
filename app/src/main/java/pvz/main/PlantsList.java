package pvz.main;

import java.util.Scanner;

import pvz.plant.*;

public class PlantsList implements Option {
    public void plantView(Plant plant) {
        System.out.println(plant.getName());
        System.out.println("===============================");
        System.out.println("Health: " + plant.getHealth());
        System.out.println("Attack: " + plant.getAttackDamage());
        System.out.println("Speed: " + plant.getAttackSpeed());
        System.out.println("===============================");
    }

    @Override
    public void select() {
        Scanner scanner = ScannerUtil.getScanner();
        int choice = -1;
        Plant plant;

        do {
            System.out.println("Lalapan List: ");
            System.out.println("Choose Lalapan's number to see the details: ");
            System.out.println("===============================");
            System.out.println("1. Chomper");
            System.out.println("2. Jalapeno");
            System.out.println("3. Lilypad");
            System.out.println("4. Peashooter");
            System.out.println("5. Snowpea");
            System.out.println("6. Spikeweed");
            System.out.println("7. Squash");
            System.out.println("8. Sunflower");
            System.out.println("9. Twin sunflower");
            System.out.println("10. Wallnut");
            System.out.println("0. Go Back");
            System.out.println("===============================");
            System.out.println("Enter your choice [0..10]:");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    plant = new Chomper(0);
                    plantView(plant);
                    break;
                case 2:
                    plant = new Jalapeno(0);
                    plantView(plant);
                    break;
                case 3:
                    plant = new Lilypad(0);
                    plantView(plant);
                    break;
                case 4:
                    plant = new Peashooter(0);
                    plantView(plant);
                    break;
                case 5:
                    plant = new Snowpea(0);
                    plantView(plant);
                    break;
                case 6:
                    plant = new Spikeweed(0);
                    plantView(plant);
                    break;
                case 7:
                    plant = new Squash(0);
                    plantView(plant);
                    break;
                case 8:
                    plant = new Sunflower(0);
                    plantView(plant);
                    break;
                case 9:
                    plant = new TwinSunflower(0);
                    plantView(plant);
                    break;
                case 10:
                    plant = new Wallnut(0);
                    plantView(plant);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println("Enter anything to go back to the list: ");
            scanner.nextLine();
        } while (choice != 0);
    }
}
