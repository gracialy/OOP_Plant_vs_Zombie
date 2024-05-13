package pvz.plantfactory;

import pvz.plant.*;

public class SnowpeaFactory extends PlantFactory {
    @Override
    public Plant createPlant() {
        return new Snowpea();
    }    
}
