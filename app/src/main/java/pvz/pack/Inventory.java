package pvz.pack;

import pvz.plantfactory.*;

public class Inventory extends Pack {
    // private static final int MAX_SIZE = 10;

    public Inventory(PregameMediator mediator) {
        super(mediator);

        fillInventory();
    }

    void fillInventory() {
        getPack().add(new ChomperFactory());
        getPack().add(new JalapenoFactory());
        getPack().add(new LilypadFactory());
        getPack().add(new PeashooterFactory());
        getPack().add(new SnowpeaFactory());
        getPack().add(new SpikeweedFactory());
        getPack().add(new SquashFactory());
        getPack().add(new SunflowerFactory());
        getPack().add(new TwinSunflowerFactory());
        getPack().add(new WallnutFactory());
    }

    // add to deck
    public void addToDeck(int pos) {
        getMediator().addToDeck(pos);
    }

    // remove from deck
    public void removeFromDeck(int pos) {
        getMediator().removeFromDeck(pos);
    }

    // swap inventory
    public void swapInventory(int pos1, int pos2) {
        getMediator().swapInventory(pos1, pos2);
    }
}
