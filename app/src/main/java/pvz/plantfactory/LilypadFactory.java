package pvz.plantfactory;

import pvz.plant.*;

public class LilypadFactory extends PlantFactory {
    public LilypadFactory() {
        super(10000);
    }

    @Override
    public Plant createPlant(long invokeTime) {
        try {
            if (canInvoke(invokeTime)) {
                return new Lilypad();
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
