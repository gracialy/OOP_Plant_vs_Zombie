package pvz.pack;

import java.util.*;
import org.reflections.Reflections;

import pvz.plantfactory.*;

public class Inventory extends Pack {
    public Inventory() {
        super();

        // Get all the classes that extend PlantFactory
        Reflections reflections = new Reflections("pvz.plantfactory");
        Set<Class<? extends PlantFactory>> subTypes = reflections.getSubTypesOf(PlantFactory.class);

        // Instantiate and add the classes to the inventory
        for (Class<? extends PlantFactory> subType : subTypes) {
            try {
                PlantFactory plantFactory = subType.getDeclaredConstructor().newInstance();
                add(plantFactory);
            } catch (Exception e) {
                // Handle any exceptions that occur during instantiation
                e.getMessage();
            }
        }
    }

    // add to deck
    public void addToDeck(int pos) {
        PlantFactory plantFactory = remove(pos);
        // add to deck
    }

    // remove from deck
    public void removeFromDeck(int pos) {
        // remove from deck
        // PlantFactory plantFactory = remove(pos);
        // add(plant);
    }
}
