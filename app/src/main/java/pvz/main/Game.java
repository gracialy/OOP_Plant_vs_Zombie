package pvz.main;

import pvz.pack.Deck;
import pvz.plantfactory.*;
import pvz.plant.*;
import pvz.sun.*;
import pvz.zombie.*;
import pvz.zombiefactory.*;
import pvz.map.*;
import pvz.bullet.*;

import java.util.Random;
import java.util.Scanner;

import java.util.Iterator;

import java.util.List;

public class Game extends Thread {
    private boolean inputDelay = false;
    private boolean running;
    private boolean newUpdate = true;
    private static int elapsedTime;
    private Deck deck;
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

    public boolean getRunning() {
        return running;
    }

    public boolean getInputDelay() {
        return inputDelay;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public void setInputDelay(boolean inputDelay) {
        this.inputDelay = inputDelay;
    }

    public void refreshView() {
        ToolsUtil.clearScreen();
        System.out.println("Elapsed time: " + elapsedTime + "s");
        System.out.println(map.hitungZombie());
        System.out.println("===============================");
        map.displayMap();
        System.out.println("Deck: " + deck.getInfo());
        System.out.println("Sun:" + Sun.getSunValue());
        if (choice == -1) {
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
            ZombieFactory[] arraydarat = { new LadderFactory(), new PoleVaultFactory() };
            ZombieFactory[] arrayair = { new DolphinFactory() };

            if (newUpdate) {
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
            if (elapsedTime % 200 <= 100) {
                Sun.produceSun(elapsedTime);
            }

            // produce zombie
            if ((elapsedTime % 3 == 0 || isFlag())) { // TODO: TAMBAHIN (elapsedTime >= 20 && elapsedTime <= 160) &&
                for (int i = 0; i < 6; i++) {
                    if (map.hitungZombie() < 10 || (isFlag() && map.hitungZombie() < 25)) {
                        double randomValue = getRandomValue(lowerBound, upperBound);
                        if (randomValue <= 0.3) {
                            Random random = new Random();
                            if (i == 2 || i == 3) {
                                int x = random.nextInt(arrayair.length);
                                Zombie zomb = arrayair[x].createZombie();
                                map.zombie(i, 10, zomb);
                            } else {
                                int x = random.nextInt(arraydarat.length);
                                Zombie zomb = arraydarat[x].createZombie();
                                map.zombie(i, 10, zomb);
                            }
                            newUpdate = true;
                        }
                    }

                }
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
                    } else {
                        Sun.useSun(plantFactory.getCost());
                    }

                    choice = -1;
                    break;

                case 2:
                    System.out.println("Enter the row number: ");
                    row = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the column number: ");
                    column = Integer.parseInt(scanner.nextLine());

                    map.removePlant(row, column);

                    choice = -1;
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    choice = -1;
                    inputDelay = false;
                    break;
            }

            try {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 11; j++) {
                        Plant plant1 = map.getTile(i, j).getPlant();
                        Tile tile = map.getTile(i, j);
                        synchronized (tile) {
                            // plant action
                            if (plant1 instanceof Sunflower) {
                                Sunflower sunflower = (Sunflower) plant1;
                                if (sunflower.isAttackTime(elapsedTime)) {
                                    sunflower.produceSun(elapsedTime);
                                }
                            }
                            else if (plant1 instanceof TwinSunflower) {
                                TwinSunflower twinSunflower = (TwinSunflower) plant1;
                                if (twinSunflower.isAttackTime(elapsedTime)) {
                                    twinSunflower.produceSun(elapsedTime);
                                }
                            }
                            else if (plant1 != null) {
                                if (plant1.isAttackTime(elapsedTime)) {
                                    Bullet bullet = new Bullet(plant1, i, j);
                                    if (bulletShot(bullet)) {
                                        plant1.setLastAttackTime(elapsedTime);
                                        if (plant1 instanceof Jalapeno || plant1 instanceof Squash) {
                                            tile.removePlant();
                                        }
                                    }
                                }
                            }

                            // zombie attack
                            if (plant1 != null && !tile.getZombies().isEmpty()) {
                                Iterator<Zombie> zombieIterator = tile.getZombies().iterator();
                                while (zombieIterator.hasNext()) {
                                    Zombie zombie = zombieIterator.next();
                                    if (zombie.isAttackTime(elapsedTime)) {
                                        plant1.takeDamage(zombie.getAttackDamage());
                                        zombie.setLastAttackTime(elapsedTime);
                                        if (plant1.getHealth() <= 0) {
                                            tile.removePlant();
                                            break;
                                        }
                                    }
                                }
                            }

                            // zombie walk
                            if (!tile.getZombies().isEmpty()) {
                                if (tile.getPlant() == null) {
                                    ZombieWalk(i, tile.getZombies(), elapsedTime);
                                }
                            }
                        }
                    }
                }

                // check game over
                for (int i = 0; i < 5; i++) {
                    Tile tile = map.getTile(i, 0);
                    if (tile.getZombies().size() != 0) {
                        running = false;
                        System.out.println("\u001B[31mYOU LOSE!\u001B[0m");
                        System.out.println("Enter anything to go back to the main menu.");
                    }
                }
                if (map.hitungZombie() == 0 && elapsedTime > 160) {
                    running = false;
                    System.out.println("\u001B[32mYOU WIN\u001B[0m");
                }
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

                Bullet bullet = new Bullet(plant, i, j);
                if (bulletShot(bullet))
                    plant.setLastAttackTime(currentTime);
            }
        }
    }

    public boolean bulletShot(Bullet bullet) {
        boolean hit = false;
        List<Zombie> zombies;
        int row = bullet.getOriginX();
        int col = bullet.getOriginY();

        switch (bullet.getRange()) {
            case 1:
                zombies = map.getTile(row, col).getZombies();

                for (Zombie zombie : zombies) {
                    zombie.takeDamage(bullet.getDamage(), bullet.hasSlowEffect(), elapsedTime);
                }

                if (zombies.size() > 0) {
                    hit = true;
                    map.getTile(row, col).removeZombie();
                }

                break;
            case (-1):
                for (int i = col; i < Map.COLS; i++) {
                    zombies = map.getTile(row, i).getZombies();
                    for (Zombie zombie : zombies) {
                        zombie.takeDamage(bullet.getDamage(), bullet.hasSlowEffect(), elapsedTime);
                    }
                    if (zombies.size() > 0) {
                        hit = true;
                        map.getTile(row, i).removeZombie();
                    }
                    if (hit == true && !bullet.isImmortal())
                        break;
                }

                break;
        }
        return hit;
    }

    public void ZombieWalk(int row, List<Zombie> zombies, int currentTime) {
        Iterator<Zombie> iterator = zombies.iterator();
        while (iterator.hasNext()) {
            Zombie zombie = iterator.next();

            if ((Game.elapsedTime - zombie.getWaktuZomb()) % zombie.getSpeed(currentTime) != 0 || Game.elapsedTime == zombie.getWaktuZomb()) {
                continue;
            }
            zombie.setWaktuZomb(Game.elapsedTime);
            for (int col = 0; col < 11; col++) {
                Tile tile = map.getTile(row, col);
                synchronized (tile) {
                    if (!tile.getZombies().contains(zombie)) {
                        continue;
                    }
                    if (col > 0) {
                        Tile leftTile = map.getTile(row, col - 1);
                        if (leftTile.getPlant() != null
                                && (zombie instanceof PoleVault || zombie instanceof DolphinRider
                                        || zombie instanceof LadderZombie)) {
                            if (!zombie.getJump()) {
                                Tile newTile = map.getTile(row, col - 2);
                                iterator.remove();
                                tile.removeZombie(zombie);
                                leftTile.removePlant();
                                newTile.addZombie(zombie);
                                zombie.setJump(true);
                            } else {
                                newUpdate = true;
                                leftTile.addZombie(zombie);
                                iterator.remove();
                                tile.removeZombie(zombie);
                            }
                        } else {
                            newUpdate = true;
                            leftTile.addZombie(zombie);
                            iterator.remove();
                            tile.removeZombie(zombie);
                        }
                        break;
                    }
                }
            }
        }
    }

    public static int getElapsedTime() {
        return elapsedTime;
    }

    private boolean isFlag() {
        return elapsedTime >= 150 && elapsedTime <= 160;
    } 

    public void jump(int row, int col, Zombie zombie) {
        if (!zombie.getJump()) {
            Tile tile = map.getTile(row, col);
            Tile tilePlant = map.getTile(row, col - 1);
            Tile newTile = map.getTile(row, col - 2);

            tile.removeZombie(zombie);
            tilePlant.removePlant();
            newTile.addZombie(zombie);

            zombie.setJump(true);
        }
    }

    public void attackZomb(int currentTime) {
        for (int i = 0; i < Map.ROWS; i++) {
            for (int j = 0; j < Map.COLS; j++) {
                Tile posisi = map.getTile(i, j);
                synchronized (posisi) {
                    Plant plant = posisi.getPlant();
                    if (plant != null && !posisi.getZombies().isEmpty()) {
                        Iterator<Zombie> zombieIterator = posisi.getZombies().iterator();
                        while (zombieIterator.hasNext()) {
                            Zombie zombie = zombieIterator.next();
                            if (zombie.isAttackTime(currentTime)) {
                                plant.takeDamage(zombie.getAttackDamage());
                                zombie.setLastAttackTime(currentTime);
                                if (plant.getHealth() <= 0) {
                                    posisi.removePlant();
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void SunSunFlower(int currentTime) {
        for (int i = 0; i < Map.ROWS; i++) {
            for (int j = 0; j < Map.COLS; j++) {
                Tile posisi = map.getTile(i, j);
                synchronized (posisi) {
                    Plant plant = posisi.getPlant();
                    if (plant instanceof Sunflower) {
                        Sunflower sunflower = (Sunflower) plant;
                        if (sunflower.isAttackTime(currentTime)) {
                            Sun.addSun(25);
                            sunflower.setLastAttackTime(currentTime);
                        }
                    }
                }
            }
        }
    }
}