import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class PlaneTest {

    @Test
    @DisplayName("It is grounded by default")
    void statusIsGroundByDefault() {
        Plane plane = new Plane();
        Assertions.assertEquals(plane.status, "Ground");
    }

    @Test
    @DisplayName("It can be taken off")
    void takeOffChangesStatus() throws TakeOffException {
        Plane plane = new Plane();

        plane.takeOff();
        Assertions.assertEquals(plane.status, "Air");
    }

    @Test
    @DisplayName("It can be landed")
    void landChangesStatusToGround() throws LandingException, TakeOffException, CapacityException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.takeOff();
        Assertions.assertEquals(plane.status, "Air");

        plane.land(airport);
        Assertions.assertEquals(plane.status, "Ground");
    }

    @Test
    @DisplayName("It throws error when trying to land a grounded plane")
    void landThrowsErrorWhenGrounded() {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        Assertions.assertThrows(LandingException.class, () -> plane.land(airport));
    }

    @Test
    @DisplayName("It throws error when trying to take off an airborne plane")
    void takeOffThrowsErrorWhenAirborne() throws TakeOffException {
        Plane plane = new Plane();
        plane.takeOff();
        Assertions.assertThrows(TakeOffException.class, plane::takeOff);
    }

    @Test
    void itCallsLandMethodToAirport() throws CapacityException, LandingException, TakeOffException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.takeOff();
        plane.land(airport);

        verify(airport).land(plane);
    }
}