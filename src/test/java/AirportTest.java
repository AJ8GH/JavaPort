import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class AirportTest {

    @Test
    @DisplayName("Hangar is empty by default")
    void hangarIsEmptyByDefault() {
        Airport airport = new Airport();
        Assertions.assertEquals(airport.hangar.size(), 0);
    }

    @Test
    @DisplayName("Plane is added to hangar after landing")
    void successfulLanding() {
        Airport airport = new Airport();
        Plane plane = mock(Plane.class);

        airport.land(plane);
        Assertions.assertTrue(airport.hangar.contains(plane));
    }
}