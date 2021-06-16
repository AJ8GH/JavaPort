import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class PlaneTest {

    @Test
    @DisplayName("It is airborne by default")
    void statusIsGroundByDefault() {
        Plane plane = new Plane();
        Assertions.assertEquals(plane.status, "Air");
    }

    @Test
    @DisplayName("It can be landed")
    void landChangesStatusToGround() throws LandingException, CapacityException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);

        Assertions.assertEquals(plane.status, "Ground");
    }

    @Test
    @DisplayName("It can be taken off")
    void takeOffChangesStatus() throws TakeOffException, LandingException, CapacityException, AirportException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);
        Assertions.assertEquals(plane.status, "Ground");

        plane.takeOff(airport);
        Assertions.assertEquals(plane.status, "Air");
    }

    @Test
    @DisplayName("It throws error when trying to land a grounded plane")
    void landThrowsErrorWhenGrounded() throws LandingException, CapacityException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);

        Assertions.assertThrows(LandingException.class, () -> plane.land(airport));
    }

    @Test
    @DisplayName("It throws error when trying to take off an airborne plane")
    void takeOffThrowsErrorWhenAirborne() {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        Assertions.assertThrows(TakeOffException.class, () -> plane.takeOff(airport));
    }

    @Test
    void landCallsLandMethodToAirport() throws CapacityException, LandingException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);

        verify(airport).land(plane);
    }

    @Test
    void takeOffCallsTakeOffToAirport() throws LandingException, CapacityException, AirportException, TakeOffException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);
        plane.takeOff(airport);

        verify(airport).takeOff(plane);
    }
}