package pvz.plantfactory;

import pvz.plant.*;

public class ChomperFactory extends PlantFactory {
    public ChomperFactory() {
        super(20000);
    }

    @Override
    public Plant createPlant(long coolDownTime) {
        try {
            if (canInvoke(coolDownTime)) {
                return new Chomper();
            }
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
