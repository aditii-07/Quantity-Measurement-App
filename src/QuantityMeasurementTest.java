package com.measurement;

import com.measurement.weight.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementTest {

    @Test
    void testEquality_Kg_Gram() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);

        assertTrue(kg.equals(g));
    }

    @Test
    void testConversion_Kg_To_Pound() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight lb = kg.convertTo(WeightUnit.POUND);

        assertEquals(2.20462, lb.getValue(), 0.01);
    }

    @Test
    void testAddition_CrossUnit() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = kg.add(g);

        assertEquals(2.0, result.getValue(), 0.0001);
    }

    @Test
    void testAddition_ExplicitTarget() {
        QuantityWeight kg = new QuantityWeight(1.0, WeightUnit.KILOGRAM);
        QuantityWeight g = new QuantityWeight(1000.0, WeightUnit.GRAM);

        QuantityWeight result = kg.add(g, WeightUnit.GRAM);

        assertEquals(2000.0, result.getValue(), 0.0001);
    }
}