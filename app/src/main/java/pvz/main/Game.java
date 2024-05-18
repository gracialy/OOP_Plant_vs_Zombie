package pvz.main;

import pvz.pack.Deck;
import pvz.plantfactory.*;
import pvz.plant.*;
import pvz.sun.*;
import pvz.zombie.BucketHat;
import pvz.zombie.Conehead;
import pvz.zombie.DiggerZombie;
import pvz.zombie.DolphinRider;
import pvz.zombie.DuckyTube;
import pvz.zombie.FlagZombie;
import pvz.zombie.LadderZombie;
import pvz.zombie.Newspaper;
import pvz.zombie.NormalZombie;
import pvz.zombie.PoleVault;
import pvz.zombie.Zombie;
import pvz.map.*;

import java.util.Random;
import java.util.Scanner;

public class Game implements Runnable {
    private boolean running;
    private long elapsedTime;
    private Deck deck;
    private Map map = new Map();
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
            
            double lowerBound = 0.0;
            double upperBound = 1.0;
            Zombie[] arraydarat = { new NormalZombie(), new Newspaper(), new Conehead(), new BucketHat(),
                    new DiggerZombie(), new FlagZombie(), new LadderZombie() };
            Zombie[] arrayair = { new PoleVault(), new DolphinRider(), new DuckyTube() };

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
            map.displayMap();
            int choice = -1;
            for (int i = 0; i < 6; i++) {
                if (map.hitungZombie() < 10) {
                    double randomValue = getRandomValue(lowerBound, upperBound);
                    if (randomValue <= 0.3) {
                        Random random = new Random();
                        if (i == 2 || i == 3) {
                            int x = random.nextInt(arrayair.length);
                            Zombie zomb = arrayair[x];
                            map.zombie(i, 10, zomb);
                        } else {
                            int x = random.nextInt(arraydarat.length);
                            Zombie zomb = arraydarat[x];
                            map.zombie(i, 10, zomb);
                        }
                    }
                }

                map.displayMap();
                System.out.println(map.hitungZombie());
            }
            System.out.println("===============================");
            System.out.println("1. Place Plant");
            System.out.println("2. Remove Plant");
            System.out.println("0. End Game");
            System.out.println("===============================");
            System.out.println("Enter your choice [0..2]: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
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

                    plantFactory = (PlantFactory) deck.getPack().get(choice - 1);
                    try {
                        timeCache = plantFactory.getLastInvokeTime();
                        plant = plantFactory.createPlant(elapsedTime, Sun.getSunValue());
                    } catch (Exception e) {
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static double getRandomValue(double lowerBound, double upperBound) {
        Random random = new Random();
        return lowerBound + (random.nextDouble() * (upperBound - lowerBound));
    }

}
