import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class WeatherTest {
    @Test
    @DisplayName("#forecast() - sunny when pressure is low")
    void sunnyForecast() {
        Random random = new Random(1);
        Weather weather = new Weather(random);
        Assertions.assertEquals(weather.forecast(), "Sunny");
    }

    @Test
    @DisplayName("#forecast() - stormy when pressure is low")
    void stormyForecast() {
        Random random = new Random(20);
        Weather weather = new Weather(random);
        Assertions.assertEquals(weather.forecast(), "Stormy");
    }
}