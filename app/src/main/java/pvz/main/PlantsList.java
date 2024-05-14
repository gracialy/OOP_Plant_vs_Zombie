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
        System.out.println("1. Plant1");
        System.out.println("0. Go Back");
        System.out.println("===============================");
        System.out.println("Enter your choice [0..10]:");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                // placeholder
                System.out.println("Lalapam1");
                System.out.println("Health: 100");
                System.out.println("Attack: 10");
                System.out.println("Speed: 1");
                break;
            case 0:
                break;
            // can exception maybe
        }
    }
}
