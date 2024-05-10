package pvz.menu;

public class Exit implements Menu {
    @Override
    public void select() {
        // exit the game
        System.out.println("Exiting the game...");
        System.exit(0);
    }
}
