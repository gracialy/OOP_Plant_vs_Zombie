package pvz;

public class Game {
    private static boolean isRunning;

    public Game() {
        isRunning = false;
    }


    public void start() {
        isRunning = true;
        while (isRunning) {
            System.out.println("Game start");
        }
    }

    public void help() {

    }

    public void plants_list() {

    }

    public void zombies_list() {

    }

    public void exit() {
        System.out.println("Game exit");
        isRunning = false;
        exit();
    }
}
