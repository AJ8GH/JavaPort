import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class AirportTest {

    @Test
    @DisplayName("#hangar() - it is empty by default")
    void hangarIsEmptyByDefault() {
        Weather weather = mock(Weather.class);
        Airport airport = new Airport(weather);

        Assertions.assertEquals(0, airport.hangar().size());
    }

    @Test
    @DisplayName("#land() - plane is added to hangar after landing")
    void successfulLanding() throws CapacityException, WeatherException {
        Weather weather = mock(Weather.class);
        Airport airport = new Airport(weather);
        when(weather.forecast()).thenReturn("Sunny");
        Plane plane = mock(Plane.class);

        airport.land(plane);

        Assertions.assertTrue(airport.contains(plane));
    }

    @Test
    @DisplayName("#land() - CapacityException is thrown when capacity is full")
    void landingWhenCapacityFull() throws CapacityException, WeatherException {
        Weather weather = mock(Weather.class);
        Airport airport = new Airport(weather);
        when(weather.forecast()).thenReturn("Sunny");

        for (int i = 0; i < 50; i++) {
            Plane plane = mock(Plane.class);
            airport.land(plane);
        }

        Plane plane = mock(Plane.class);

        Assertions.assertThrows(CapacityException.class, () -> airport.land(plane));
    }

    @Test
    @DisplayName("#takeOff() - plane is removed from hangar after take off")
    void successfulTakeOff() throws CapacityException, AirportException, WeatherException {
        Weather weather = mock(Weather.class);
        Airport airport = new Airport(weather);
        when(weather.forecast()).thenReturn("Sunny");
        Plane plane = mock(Plane.class);

        airport.land(plane);
        Assertions.assertTrue(airport.contains(plane));

        airport.takeOff(plane);
        Assertions.assertFalse(airport.contains(plane));
    }

    @Test
    @DisplayName("#takeOff() - exception thrown if plane is not in airport")
    void takeOffWhenPlaneNotInAirport() throws CapacityException, WeatherException {
        Weather weather = mock(Weather.class);
        when(weather.forecast()).thenReturn("Sunny");
        Airport airport1 = new Airport(weather);
        Airport airport2 = new Airport(weather);
        Plane plane = mock(Plane.class);

        airport1.land(plane);

        Assertions.assertThrows(AirportException.class, () -> airport2.takeOff(plane));
    }

    @Test
    @DisplayName("#takeOff() - exception thrown if weather is stormy")
    void takeOffWhenWeatherStormy() throws WeatherException, CapacityException {
        Weather weather = mock(Weather.class);
        Airport airport = new Airport(weather);
        Plane plane = mock(Plane.class);

        when(weather.forecast()).thenReturn("Sunny");
        airport.land(plane);
        when(weather.forecast()).thenReturn("Stormy");

        Assertions.assertThrows(WeatherException.class, () -> airport.takeOff(plane));
    }

    @Test
    @DisplayName("#land() - exception thrown if weather is stormy")
    void landWhenWeatherStormy() {
        Weather weather = mock(Weather.class);
        Airport airport = new Airport(weather);
        Plane plane = mock(Plane.class);

        when(weather.forecast()).thenReturn("Stormy");

        Assertions.assertThrows(WeatherException.class, () -> airport.land(plane));
    }
}