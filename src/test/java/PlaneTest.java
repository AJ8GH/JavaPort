import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class PlaneTest {

    @Test
    @DisplayName("#status - It is Air by default")
    void statusIsGroundByDefault() {
        Plane plane = new Plane();
        Assertions.assertEquals(plane.status, "Air");
    }

    @Test
    @DisplayName("#land() - changes status to Ground")
    void landChangesStatusToGround() throws LandingException, CapacityException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);

        Assertions.assertEquals(plane.status, "Ground");
    }


    @Test
    @DisplayName("#land() - throws error when plane is grounded")
    void landThrowsErrorWhenGrounded() throws LandingException, CapacityException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);

        Assertions.assertThrows(LandingException.class, () -> plane.land(airport));
    }

    @Test
    @DisplayName("#land() - makes land method call to airport")
    void landCallsLandMethodToAirport() throws CapacityException, LandingException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);

        verify(airport).land(plane);
    }

    @Test
    @DisplayName("#takeOff() - changes status to Air")
    void takeOffChangesStatus() throws TakeOffException, LandingException, CapacityException, AirportException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);
        Assertions.assertEquals(plane.status, "Ground");

        plane.takeOff(airport);
        Assertions.assertEquals(plane.status, "Air");
    }

    @Test
    @DisplayName("#takeOff() - throws error when plane is airborne")
    void takeOffThrowsErrorWhenAirborne() {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        Assertions.assertThrows(TakeOffException.class, () -> plane.takeOff(airport));
    }

    @Test
    @DisplayName("#takeOff() - makes take off method call to airport")
    void takeOffCallsTakeOffToAirport() throws LandingException, CapacityException, AirportException, TakeOffException {
        Plane plane = new Plane();
        Airport airport = mock(Airport.class);

        plane.land(airport);
        plane.takeOff(airport);

        verify(airport).takeOff(plane);
    }
}