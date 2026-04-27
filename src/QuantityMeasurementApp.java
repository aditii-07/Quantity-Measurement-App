public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);

        QuantityLength result = QuantityLength.add(q1, q2);

        System.out.println("Result: " + result);
        QuantityLength result2 = QuantityLength.add(q2, q1);
        System.out.println("Reverse Result: " + result2);
    }
}