package pvz.plantfactory;

import pvz.plant.*;

public class LilypadFactory extends PlantFactory {
    @Override
    public Plant createPlant() {
        return new Lilypad();
    }    
}
