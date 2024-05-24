package pvz.main;

import java.util.Scanner;

import pvz.zombie.*;

public class ZombiesList implements Option {
    public void zombieView(Zombie zombie)
    {
        System.out.println(zombie.getName());
        System.out.println("===============================");
        System.out.println("Health: " + zombie.getHealth());
        System.out.println("Attack: " + zombie.getAttackDamage());
        System.out.println("Speed: " + zombie.getAttackSpeed());
        System.out.println("===============================");
    }
    
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

            Zombie zombie;

            switch (choice) {
                // TODO: Change all to the correct zombie name and details
                // TODO: (Titipan) tolong cek detail ZombiesList dong udah sesuai gak nilainya
                case 1:
                    zombie = new NormalZombie(0);
                    zombieView(zombie);
                    break;
                case 2:
                    zombie = new Conehead(0);
                    zombieView(zombie);
                    break;
                case 3:
                    zombie = new PoleVault(0);
                    zombieView(zombie);
                    break;
                case 4:
                    zombie = new BucketHat(0);
                    zombieView(zombie);
                    break;
                case 5:
                    zombie = new DuckyTube(0);
                    zombieView(zombie);
                    break;
                case 6:
                    zombie = new DolphinRider(0);
                    zombieView(zombie);
                    break;
                case 7:
                    zombie = new DiggerZombie(0);
                    zombieView(zombie);
                    break;
                case 8:
                    zombie = new FlagZombie(0);
                    zombieView(zombie);
                    break;
                case 9:
                    zombie = new LadderZombie(0);
                    zombieView(zombie);
                    break;
                case 10:
                    zombie = new Newspaper(0);
                    zombieView(zombie);
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
