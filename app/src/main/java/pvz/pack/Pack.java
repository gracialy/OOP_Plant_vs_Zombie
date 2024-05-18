package pvz.pack;

import java.util.*;

import pvz.plantfactory.*;

public class Pack {
    private List<Object> pack;
    private PregameMediator mediator;

    public Pack(PregameMediator mediator) {
        this.mediator = mediator;
        pack = new ArrayList<>();
    }

    public PregameMediator getMediator() {
        return mediator;
    }

    public List<Object> getPack() {
        return pack;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        int count = 1;
        for (Object object : pack) {
            if (object instanceof PlantFactory) {
                sb.append(count++).append(". ").append(object.getClass().getSimpleName()).append(" (").append(((PlantFactory) object).getCost()).append(")").append(" | ");
            }
            else {
                sb.append(count++).append(". Empty | ");
            }

        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 3); // Remove the last " | "
        }
        sb.append(" ]");
        return sb.toString();
    }

    public void opAdd(PlantFactory plant) throws IllegalStateException {   
        boolean found = false;

        for (int i=0; i<pack.size(); i++) {
            if (!(pack.get(i) instanceof PlantFactory)) {
                    found = true;
                    pack.set(i, plant);
                    break;
            }
        }

        if (!found) {
            throw new IllegalStateException("Slot is full.");
        }
    }

    public PlantFactory opRemove(int pos) throws IllegalArgumentException {
        Object object = pack.get(pos-1);

        if (object instanceof PlantFactory) {
            pack.remove(object);
            pack.add(new Object());
            return (PlantFactory) object;
        }
        else {
            throw new IllegalArgumentException("Invalid position.");
        }
    }
    
    public void opSwap(int pos1, int pos2) throws IllegalArgumentException {
        if (pos1 == pos2) {
            throw new IllegalArgumentException("Cannot swap the same position.");
        }
        else if (!(pack.get(pos1-1) instanceof PlantFactory && pack.get(pos2-1) instanceof PlantFactory)) {
            throw new IllegalArgumentException("Cannot swap empty slot.");
        }

        PlantFactory tmp = (PlantFactory) pack.get(pos1-1);
        pack.set(pos1-1, pack.get(pos2-1));
        pack.set(pos2-1, tmp);
    }
}
