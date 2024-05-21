package pvz.main;

import pvz.pack.Deck;
import pvz.plantfactory.*;
import pvz.plant.*;
import pvz.sun.*;
import pvz.zombie.*;
import pvz.map.*;
import pvz.bullet.*;

import java.util.Random;
import java.util.Scanner;

import java.util.Iterator;

import java.util.List;

public class Game extends Thread {
    public boolean inputDelay = false;
    private boolean running;
    private boolean newUpdate = true;
    private static int elapsedTime;
    public Deck deck;
    private Map map = new Map();
    // private Sun sun;
    public Scanner scanner;
    private int choice = -1;
    private Time time;
    
    public Game(Deck deck) {
        this.running = true;
        this.deck = deck;
        this.map = new Map();
        this.time = new Time();
        // this.sun = Sun.getInstance();
        // this.scanner = ScannerUtil.getScanner();
        this.scanner = new Scanner(System.in);
    }

    public void setChoice(int choice)
    {
        this.choice = choice;
    }

    public int getChoice()
    {
        return choice;
    }

    public void refreshView()
    {
        ToolsUtil.clearScreen();
        System.out.println("Elapsed time: " + time.getElapsedTime() + "ms");
        System.out.println("Zombies on map: " + map.hitungZombie());
        System.out.println("===============================");
        map.displayMap();
        System.out.println("Deck: " + deck.getInfo());
        System.out.println("Sun:" + Sun.getSunValue());
        if (choice == -1)
        {
            System.out.println("===============================");
            System.out.println("1. Place Plant");
            System.out.println("2. Remove Plant");
            System.out.println("0. End Game");
            System.out.println("===============================");
            System.out.println("Enter your choice [0..2]: ");
        }
    }

    public void run() {
        while (running) {
            PlantFactory plantFactory;
            Plant plant;
            int row, column;
            long timeCache;
            
            double lowerBound = 0.0;
            double upperBound = 1.0;
            Zombie[] arraydarat = { new NormalZombie(elapsedTime), new Newspaper(elapsedTime), new Conehead(elapsedTime), new BucketHat(elapsedTime), new DiggerZombie(elapsedTime), new FlagZombie(elapsedTime), new LadderZombie(elapsedTime) };
            Zombie[] arrayair = { new PoleVault(elapsedTime), new DolphinRider(elapsedTime), new DuckyTube(elapsedTime) };
                    
            if (newUpdate)
            {
                refreshView();
                newUpdate = false;
            }

            // TODO: Sunflower sun production
            // TODO: Zombie spawning
            // TODO: Plant attack
            // TODO: Zombie attack
            // TODO: Zombie moving

            // TODO: Test plant placing
            // TODO: Test sun producing

            // produce sun
            Sun.produceSun(time.getElapsedTime());
            // produce zombie
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
                        newUpdate = true;
                    }
                }

            }
            try {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 11; j++) {
                        Tile tile = map.getTile(i, j);
                        synchronized (tile) {
                            if (!(tile.getPlant() == null)) {

                            }
                            if (!tile.getZombies().isEmpty()) {
                                if (tile.getPlant() == null) {
                                    ZombieWalk(i, tile.getZombies());
                                }
                            }

                        }
                    }
                }
                Thread.sleep(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // attack plant
            
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

                    choice = -1;
                    inputDelay= false;

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
                    choice = -1;
                    inputDelay = false;
                    // System.out.println(inputDelay);
                    // System.out.println("Invalid choice. Please try again.");
                    break;
            }

            try {
                Thread.sleep(1000);
                elapsedTime = (int) (time.getElapsedSeconds());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static double getRandomValue(double lowerBound, double upperBound) {
        Random random = new Random();
        return lowerBound + (random.nextDouble() * (upperBound - lowerBound));
    }

    public void plantAttack(int currentTime) {
        for (int i = 0; i <= Map.ROWS; i++) {
            for (int j = 0; j <= Map.COLS; j++) {
                Plant plant = map.getTile(i, j).getPlant();

                if (plant == null)
                    continue;
                if (plant.getAttackDamage() == 0)
                    continue;
                if (!plant.isAttackTime(currentTime))
                    continue;

                plant.setLastAttackTime(currentTime);
                Bullet bullet = new Bullet(plant, i, j);
                bulletShot(bullet);
            }
        }
    }

    public void bulletShot(Bullet bullet) {
        List<Zombie> zombies;
        int row = bullet.getOriginX();
        int col = bullet.getOriginY();

        switch (bullet.getRange()) {
            case 1:
                zombies = map.getTile(row, col).getZombies();

                for (Zombie zombie : zombies) {
                    zombie.takeDamage(bullet.getDamage(), bullet.hasSlowEffect());
                    if (zombie.isDead())
                        map.getTile(row, col).removeZombie(zombie);
                }

                break;
            case (-1):
                for (int i = col; i <= Map.COLS; i++) {
                    zombies = map.getTile(row, i).getZombies();

                    for (Zombie zombie : zombies) {
                        zombie.takeDamage(bullet.getDamage(), bullet.hasSlowEffect());
                        if (zombie.isDead())
                            map.getTile(row, col).removeZombie(zombie);
                    }

                    if (zombies.size() > 0)
                        break;
                }

                break;
        }
    }

    public void ZombieWalk(int row, List<Zombie> zombies) {
        Iterator<Zombie> iterator = zombies.iterator();
        while (iterator.hasNext()) {
            Zombie zombie = iterator.next();
            if ((Game.elapsedTime - zombie.getWaktuZomb()) % 5 != 0 || Game.elapsedTime==zombie.getWaktuZomb()) {
                continue;
            }
            for (int col = 0; col < 11; col++) {
                Tile tile = map.getTile(row, col);
                synchronized (tile) {
                    if (!tile.getZombies().contains(zombie)) {
                        continue;
                    }
                    if (col > 0) {
                        Tile leftTile = map.getTile(row, col - 1);
                        if (leftTile.getPlant() != null
                                && (zombie instanceof PoleVault || zombie instanceof DolphinRider)) {
                            ;
                        } else {
                            newUpdate = true;
                            leftTile.addZombie(zombie);
                            iterator.remove(); // Menghapus zombie dari list
                        }
                    }
                    break;
                }
            }
        }
    }

    public static int getElapsedTime() {
        return elapsedTime;
    }
}