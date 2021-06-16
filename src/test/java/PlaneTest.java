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
}