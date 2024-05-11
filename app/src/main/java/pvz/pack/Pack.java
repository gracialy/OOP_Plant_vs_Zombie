package pvz.pack;

import java.util.*;

import pvz.plantfactory.*;

public class Pack {
    private Set<PlantFactory> pack;

    public Pack() {
        pack = new LinkedHashSet<>();
    }

    public Set<PlantFactory> getPack() {
        return pack;
    }

    public PlantFactory getFactory(int pos) {
        // Convert position to index
        int index = pos - 1;

        // Check if index is valid
        if (index < 0 || index >= pack.size()) {
            throw new IllegalArgumentException("Empty slot or invalid position.");
        }

        PlantFactory[] packArray = pack.toArray(new PlantFactory[0]);
        return packArray[index];
    }

    public void printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        int count = 1;
        for (PlantFactory plantFactory : pack) {
            sb.append(count++).append(". ").append(plantFactory.getClass().getSimpleName()).append(" | ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 3); // Remove the last " | "
        }
        sb.append(" ]\n");
        System.out.print(sb.toString());
    }

    public PlantFactory remove(int pos) {
        // Convert position to index
        int index = pos - 1;

        // Check if index is valid
        if (index < 0 || index >= pack.size()) {
            throw new IllegalArgumentException("Empty slot or invalid position.");
        }

        PlantFactory[] packArray = pack.toArray(new PlantFactory[0]);
        PlantFactory deletedPlant = packArray[index];
        pack.remove(deletedPlant);
        return deletedPlant;
    }

    public void add(PlantFactory plant) {
        pack.add(plant);
    }
    
    public void swap(int pos1, int pos2) {
        // Convert positions to indices
        int index1 = pos1 - 1;
        int index2 = pos2 - 1;

        // Check if indices are valid
        if (index1 < 0 || index1 >= pack.size() || index2 < 0 || index2 >= pack.size()) {
            throw new IllegalArgumentException("Empty slot or invalid position.");
        }

        PlantFactory[] packArray = pack.toArray(new PlantFactory[0]);
        PlantFactory temp = packArray[index1];
        packArray[index1] = packArray[index2];
        packArray[index2] = temp;
    }
}
