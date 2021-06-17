import java.util.Random;

class Weather {
    private final Random random;

    Weather(Random random) {
        this.random = random;
    }

    public String forecast() {
        return atmosphericPressure() > 10 ? "Sunny" : "Stormy";
    }

    private int atmosphericPressure() {
        return random.nextInt(101);
    }
}