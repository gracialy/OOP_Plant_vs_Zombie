package pvz.menu;

public class Help implements Menu {
    @Override
    public void select() {
        // give game description
        // give game instructions
        // give game commands
        System.out.println("This is a game where you can plant plants to defend your house from zombies.");
    }
}
