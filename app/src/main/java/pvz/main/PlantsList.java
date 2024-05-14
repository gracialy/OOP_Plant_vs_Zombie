package pvz.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantsList implements Option {
    private List<String> plantNames;

    @Override
    public void select() {
        Scanner scanner = ScannerUtil.getScanner();
        
        // give list of plants
        // give plants attributes
        System.out.println("Lalapan List: ");
        System.out.println("Choose Lalapan's number to see the details: ");
        System.out.println("===============================");
        // placeholder
        int i = 1;
        for (String name : plantNames) {
            System.out.println(i + ". " + name);
            i++;
        }
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

    private void PlantsList() {
        plantNames = new ArrayList<>();
        initializePlantNames();
    }

    private void initializePlantNames() {
        plantNames.add("Sunflower");
        plantNames.add("Peashooter");
        plantNames.add("Wallnut");
        plantNames.add("Snowpea");
        plantNames.add("Lilypad");
        plantNames.add("Chomper");
        plantNames.add("Jalapeno");
        plantNames.add("Spikeweed");
        plantNames.add("TwinSunflower");
    }
}
