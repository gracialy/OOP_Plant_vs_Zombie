package pvz.plantfactory;

import pvz.plant.Snowpea;
import pvz.plant.Plant;

public class SnowpeaFactory implements PlantFactory {
    public Plant createPlant() {
        return new Snowpea();
    }
}
