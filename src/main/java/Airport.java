import java.util.ArrayList;
import java.util.List;

class Airport {
    private final List<Plane> planes;
    private final Weather weather;
    private final int DEFAULT_CAPACITY = 50;

    Airport(Weather weather) {
        this.weather = weather;
        this.planes = new ArrayList<>();
    }

    public void land(Plane plane) throws Exception {
        if (full()) throw new CapacityException();
        if (weatherIsStormy()) throw new WeatherException();
        planes.add(plane);
    }

    public void takeOff(Plane plane) throws Exception {
        if (!contains(plane)) throw new AirportException();
        if (weatherIsStormy()) throw new WeatherException();
        planes.remove(plane);
    }

    public boolean contains(Plane plane) {
        return planes.contains(plane);
    }

    private boolean weatherIsStormy() {
        return weather.forecast().equals("Stormy");
    }

    private boolean full() {
        return planes.size() >= DEFAULT_CAPACITY;
    }
}
