import java.util.ArrayList;
import java.util.List;

class Airport {
    private final List<Plane> hangar;
    private final int DEFAULT_CAPACITY = 50;

    Airport() {
        this.hangar = new ArrayList<>();
    }

    public List<Plane> hangar() {
        return this.hangar;
    }

    public void land(Plane plane) throws CapacityException {
        if (full()) throw new CapacityException();
        hangar.add(plane);
    }

    private boolean full() {
        return hangar.size() >= DEFAULT_CAPACITY;
    }
}