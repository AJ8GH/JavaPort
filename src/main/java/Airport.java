import java.util.ArrayList;
import java.util.List;

class Airport {
    public final List<Plane> hangar;

    Airport() {
        this.hangar = new ArrayList<>();
    }

    public void land(Plane plane) {
        hangar.add(plane);
    }
}