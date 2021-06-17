import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

class WeatherTest {
    @Test
    @DisplayName("#forecast() - sunny when pressure is low")
    void sunnyForecast() {
        Weather weather = new Weather(new Random(1));
        Assertions.assertEquals(weather.forecast(), "Sunny");
    }

    @Test
    @DisplayName("#forecast() - stormy when pressure is low")
    void stormyForecast() {
        Weather weather = new Weather(new Random(20));
        Assertions.assertEquals(weather.forecast(), "Stormy");
    }
}