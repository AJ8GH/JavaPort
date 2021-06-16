import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AirportTest {
    @Test
    @DisplayName("Hangar is empty by default")
    void hangarIsEmptyByDefault() {
        Airport airport = new Airport();
        Assertions.assertEquals(airport.hangar.size(), 0);
    }
}