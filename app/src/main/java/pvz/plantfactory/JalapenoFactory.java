package pvz.plantfactory;

import pvz.plant.*;

public class JalapenoFactory extends PlantFactory {
    @Override
    public Plant createPlant() {
        return new Jalapeno();
    }    
}
