package pvz.plantfactory;

import pvz.plant.*;

public class JalapenoFactory extends PlantFactory {
    public JalapenoFactory() {
        super(20000);
    }

    @Override
    public Plant createPlant(long coolDownTime) {
        try {
            if (canInvoke(coolDownTime)) {
                return new Jalapeno();
            }
        } 
        catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
