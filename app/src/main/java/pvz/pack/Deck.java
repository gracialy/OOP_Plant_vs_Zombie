package pvz.pack;

import java.util.*;

import pvz.plantfactory.*;

public class Deck extends Pack {
    private static final int MAX_SIZE = 6;

    public Deck() {
        super();
    }

    @Override
    public void add(PlantFactory plant) {
        if (getPack().size() >= MAX_SIZE) {
            throw new IllegalStateException("Deck is full.");
        }
        super.add(plant);
    }

    // plant to area
    public void plantToArea(int pos, int areaX, int areaY) {
        PlantFactory plantFactory = getFactory(pos);
        // plantFactory.createPlant(areaX, areaY);
    }

    // remove from area
    public void removeFromArea(int areaX, int areaY) {
        // remove from area
        
    }
}
