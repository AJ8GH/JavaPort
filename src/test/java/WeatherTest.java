import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeatherTest {
    @Test
    @DisplayName("#forecast() - sunny when pressure is low")
    void sunnyForecast() {
        Assertions.assertEquals(Weather.forecast(), "Sunny");
    }
}