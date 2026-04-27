import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    double EPS = 1e-6;

    @Test
    void testFeetToInches() {
        assertEquals(12.0,
                QuantityLength.convert(1, LengthUnit.FEET, LengthUnit.INCHES), EPS);
    }

    @Test
    void testInchesToFeet() {
        assertEquals(2.0,
                QuantityLength.convert(24, LengthUnit.INCHES, LengthUnit.FEET), EPS);
    }

    @Test
    void testYardsToInches() {
        assertEquals(36.0,
                QuantityLength.convert(1, LengthUnit.YARDS, LengthUnit.INCHES), EPS);
    }

    @Test
    void testCMToInches() {
        assertEquals(1.0,
                QuantityLength.convert(2.54, LengthUnit.CENTIMETERS, LengthUnit.INCHES), 1e-3);
    }

    @Test
    void testZero() {
        assertEquals(0.0,
                QuantityLength.convert(0, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    void testNegative() {
        assertEquals(-12.0,
                QuantityLength.convert(-1, LengthUnit.FEET, LengthUnit.INCHES), EPS);
    }

    @Test
    void testSameUnit() {
        assertEquals(5.0,
                QuantityLength.convert(5, LengthUnit.FEET, LengthUnit.FEET), EPS);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(1, null, LengthUnit.FEET));
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));
    }
}