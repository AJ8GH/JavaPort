import java.util.ArrayList;
import java.util.List;

class Airport {
    private final List<Plane> hangar;

    Airport() {
        this.hangar = new ArrayList<>();
    }

    public List<Plane> hangar() {
        return this.hangar;
    }

    public void land(Plane plane) {
        hangar.add(plane);
    }
}