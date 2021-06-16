import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlaneTest {

    @Test
    @DisplayName("It is grounded by default")
    void statusIsGroundByDefault() {
        Plane plane = new Plane();
        Assertions.assertEquals(plane.status, "Ground");
    }

    @Test
    @DisplayName("It can be taken off")
    void takeOffChangesStatus() {
        Plane plane = new Plane();

        plane.takeOff();
        Assertions.assertEquals(plane.status, "Air");
    }

    @Test
    @DisplayName("It can be landed")
    void landChangesStatusToGround() throws LandingException {
        Plane plane = new Plane();

        plane.takeOff();
        Assertions.assertEquals(plane.status, "Air");

        plane.land();
        Assertions.assertEquals(plane.status, "Ground");
    }

    @Test
    @DisplayName("It throws error when trying to land a grounded plane")
    void landThrowsErrorWhenGrounded() {
        Plane plane = new Plane();
        Assertions.assertThrows(LandingException.class, plane::land);
    }
}