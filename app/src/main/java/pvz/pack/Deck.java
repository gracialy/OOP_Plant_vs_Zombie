package pvz.pack;

import pvz.plantfactory.PlantFactory;

// import pvz.plantfactory.*;

public class Deck extends Pack {
    private static final int MAX_SIZE = 6;

    public Deck(PregameMediator mediator) {
        super(mediator);

        for (int i = 0; i < MAX_SIZE; i++) {
            getPack().add(new Object());
        }
    }

    public boolean isFull() {
        for (Object obj : getPack()) {
            if (!(obj instanceof PlantFactory)) {
                return false;
            }
        }
        return true;
    }

    // swap deck
    public void swapDeck(int pos1, int pos2) {
        getMediator().swapDeck(pos1, pos2);
    }
    
    // // plant to area
    // public void plantToArea(int pos, int areaX, int areaY) {
    //     PlantFactory plantFactory = getFactory(pos);
    //     // plantFactory.createPlant(areaX, areaY);
    // }

    // // remove from area
    // public void removeFromArea(int areaX, int areaY) {
    //     // remove from area
    // }
}
