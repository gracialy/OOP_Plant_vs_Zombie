package pvz.pack;

import java.util.*;
import org.reflections.Reflections;

import pvz.plantfactory.*;

public class Inventory extends Pack {
    // private static final int MAX_SIZE = 10;

    public Inventory(PregameMediator mediator) {
        super(mediator);

        // Get all the classes that extend PlantFactory
        Reflections reflections = new Reflections("pvz.plantfactory");
        Set<Class<? extends PlantFactory>> subTypes = reflections.getSubTypesOf(PlantFactory.class);

        // Instantiate and add the classes of PlantFactory type to the inventory
        for (Class<? extends PlantFactory> subType : subTypes) {
            try {
                PlantFactory plantFactory = subType.getDeclaredConstructor().newInstance();
                getPack().add(plantFactory);
            } catch (Exception e) {
                // Handle any exceptions that occur during instantiation
                e.getMessage();
            }
        }
    }

    // add to deck
    public void addToDeck(int pos) {
        getMediator().addToDeck(pos);
    }

    // remove from deck
    public void removeFromDeck(int pos) {
        getMediator().removeFromDeck(pos);
    }
}
