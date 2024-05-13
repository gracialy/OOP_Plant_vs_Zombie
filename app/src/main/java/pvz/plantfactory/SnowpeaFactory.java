package pvz.plantfactory;

import pvz.plant.*;

public class SnowpeaFactory extends PlantFactory {
    public SnowpeaFactory() {
        super(10000);
    }

    @Override
    public Plant createPlant(long coolDownTime) {
        try {
            if (canInvoke(coolDownTime)) {
                return new Snowpea();
            }
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
