package pvz.main;

import java.util.ArrayList;
import java.util.List;

public class PlantsList implements Option {
    private List<String> plantNames;

    public PlantsList() {
        this.plantNames = new ArrayList<>();
        initializePlantNames();
    }

    private void initializePlantNames() {
        plantNames.add("Sunflower");
        plantNames.add("Peashooter");
        plantNames.add("Wallnut");
        plantNames.add("Snowpea");
        plantNames.add("Lilypad");
        plantNames.add("Chomper");
        plantNames.add("Jalapeno");
        plantNames.add("Spikeweed");
        plantNames.add("TwinSunflower");
    }

    @Override
    public void select() {
        System.out.println("List of Plants:");
        int i = 1;
        for (String name : plantNames) {
            if (name != null) {
                System.out.println(i + ". " + name);
            } else {
                System.out.println(i + ". Plant not available");
            }
            i++;
        }
    }
}