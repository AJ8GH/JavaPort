import java.util.Random;

class Weather {
    private final Random random;

    Weather(Random random) {
        this.random = random;
    }

    public String forecast() {
        if (atmosphericPressure() > 10) return "Sunny";
        return "sunny";
    }

    private int atmosphericPressure() {
        return random.nextInt(101);
    }
}