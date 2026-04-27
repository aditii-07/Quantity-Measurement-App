import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(q1, q2);

        assertEquals(new QuantityLength(3, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(q1, q2);

        assertEquals(new QuantityLength(2, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength q1 = new QuantityLength(12, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(q1, q2);

        assertEquals(new QuantityLength(24, LengthUnit.INCHES), result);
    }

    @Test
    void testAddition_WithZero() {
        QuantityLength q1 = new QuantityLength(5, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(q1, q2);

        assertEquals(new QuantityLength(5, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2, LengthUnit.FEET);

        QuantityLength result = QuantityLength.add(q1, q2);

        assertEquals(new QuantityLength(3, LengthUnit.FEET), result);
    }

    @Test
    void testAddition_NullOperand() {
        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> QuantityLength.add(q1, null));
    }

    @Test
    void testAddition_Commutativity() {
        QuantityLength q1 = new QuantityLength(1, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12, LengthUnit.INCHES);

        double r1 = QuantityLength.add(q1, q2).convertTo(LengthUnit.FEET).value;
        double r2 = QuantityLength.add(q2, q1).convertTo(LengthUnit.FEET).value;

        assertEquals(r1, r2, 1e-6);
    }
}