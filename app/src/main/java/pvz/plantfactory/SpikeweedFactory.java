package pvz.plantfactory;

import pvz.plant.*;

public class SpikeweedFactory extends PlantFactory {
    public SpikeweedFactory() {
        super(20000);
    }

    @Override
    public Plant createPlant(long coolDownTime) {
        try {
            if (canInvoke(coolDownTime)) {
                return new Spikeweed();
            }
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}