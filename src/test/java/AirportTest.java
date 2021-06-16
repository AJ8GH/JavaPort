import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class AirportTest {

    @Test
    @DisplayName("Hangar is empty by default")
    void hangarIsEmptyByDefault() {
        Airport airport = new Airport();
        Assertions.assertEquals(airport.hangar().size(), 0);
    }

    @Test
    @DisplayName("Plane is added to hangar after landing")
    void successfulLanding() throws CapacityException {
        Airport airport = new Airport();
        Plane plane = mock(Plane.class);

        airport.land(plane);

        Assertions.assertTrue(airport.contains(plane));
    }

    @Test
    @DisplayName("CapacityException is thrown when capacity is full")
    void landingWhenCapacityFull() throws CapacityException {
        Airport airport = new Airport();

        for (int i = 0; i < 50; i++) {
            Plane plane = mock(Plane.class);
            airport.land(plane);
        }

        Plane plane = mock(Plane.class);

        Assertions.assertThrows(CapacityException.class, () -> airport.land(plane));
    }

    @Test
    @DisplayName("Plane is removed from hangar after take off")
    void successfulTakeOff() throws CapacityException, AirportException {
        Airport airport = new Airport();
        Plane plane = mock(Plane.class);

        airport.land(plane);
        Assertions.assertTrue(airport.contains(plane));

        airport.takeOff(plane);
        Assertions.assertFalse(airport.contains(plane));
    }

    @Test
    void takeOffWhenPlaneNotInAirport() throws CapacityException {
        Airport airport1 = new Airport();
        Airport airport2 = new Airport();

        Plane plane = mock(Plane.class);

        airport1.land(plane);

        Assertions.assertThrows(AirportException.class, () -> airport2.takeOff(plane));
    }
}