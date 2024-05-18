package pvz.main;

import pvz.pack.Deck;
import pvz.plantfactory.*;
import pvz.plant.*;
import pvz.sun.*;
import pvz.map.*;

import java.util.Scanner;

public class Game implements Runnable {
    private boolean running;
    private long elapsedTime;
    private Deck deck;
    private Map map;
    private Sun sun;
    private Scanner scanner;

    public Game(Deck deck) {
        this.running = true;
        this.deck = deck;
        this.map = new Map();
        this.sun = Sun.getInstance();
        this.scanner = ScannerUtil.getScanner();
    }

    public void run() {
        elapsedTime = 0;

        while (running) {
            PlantFactory plantFactory;
            Plant plant;
            int row, column;
            long timeCache;
            
            // TODO: Sunflower sun production
            // TODO: Zombie spawning
            // TODO: Plant attack
            // TODO: Zombie attack
            // TODO: Zombie moving
            
            // TODO: Test plant placing
            // TODO: Test sun producing

            Sun.produceSun(elapsedTime);

            System.out.println("===============================");
            map.displayMap();
            System.out.println("Deck: " + deck.getInfo());
            System.out.println("Sun:" + Sun.getSunValue());
            System.out.println("===============================");
            System.out.println("1. Place Plant");
            System.out.println("2. Remove Plant");
            System.out.println("0. End Game");
            System.out.println("===============================");
            System.out.println("Enter your choice [0..2]: ");
            int choice = -1;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please try again.");
                ToolsUtil.delay(1);
                ToolsUtil.clearScreen();
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter plant number: ");

                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 1 || choice > deck.getPack().size()) {
                        System.out.println("Invalid choice. Please try again.");
                        break;
                    }

                    plantFactory = (PlantFactory) deck.getPack().get(choice-1);
                    try {
                        timeCache = plantFactory.getLastInvokeTime();
                        plant = plantFactory.createPlant(elapsedTime, Sun.getSunValue());
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    System.out.println("Enter the row number: ");
                    row = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the column number: ");
                    column = Integer.parseInt(scanner.nextLine());

                    if (map.setPlant(row, column, plant) == 1) {
                        Sun.addSun(plantFactory.getCost());
                        plantFactory.setLastInvokeTime(timeCache);
                    } 

                    break;

                case 2:
                    System.out.println("Enter the row number: ");
                    row = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the column number: ");
                    column = Integer.parseInt(scanner.nextLine());

                    map.removePlant(row, column);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            try {
                Thread.sleep(1000);
                elapsedTime += 1000;
                ToolsUtil.clearScreen();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
