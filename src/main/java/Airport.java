import java.util.ArrayList;
import java.util.List;

class Airport {
    private final List<Plane> hangar;
    private final Weather weather;
    private final int DEFAULT_CAPACITY = 50;

    Airport(Weather weather) {
        this.weather = weather;
        this.hangar = new ArrayList<>();
    }

    public List<Plane> hangar() {
        return hangar;
    }

    public void land(Plane plane) throws CapacityException, WeatherException {
        if (full()) throw new CapacityException();
        if (weatherIsStormy()) throw new WeatherException();
        hangar.add(plane);
    }

    public void takeOff(Plane plane) throws AirportException, WeatherException {
        if (!contains(plane)) throw new AirportException();
        if (weatherIsStormy()) throw new WeatherException();
        hangar.remove(plane);
    }

    public boolean contains(Plane plane) {
        return hangar().contains(plane);
    }

    private boolean weatherIsStormy() {
        return weather.forecast().equals("Stormy");
    }

    private boolean full() {
        return hangar.size() >= DEFAULT_CAPACITY;
    }
}