package pvz.plantfactory;

import pvz.plant.*;

public class SquashFactory extends PlantFactory {
    public SquashFactory() {
        super(20000);
    }

    @Override
    public Plant createPlant(long coolDownTime) {
        try {
            if (canInvoke(coolDownTime)) {
                return new Squash();
            }
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
