public class QuantityMeasurementApp {
    public static void main(String[] args) {

        Quantity q1 = new Quantity(1.0, LengthUnit.YARDS);
        Quantity q2 = new Quantity(3.0, LengthUnit.FEET);

        System.out.println("Equal: " + q1.equals(q2));

        Quantity q3 = new Quantity(1.0, LengthUnit.CENTIMETERS);
        Quantity q4 = new Quantity(0.393701, LengthUnit.INCHES);

        System.out.println("Equal: " + q3.equals(q4));
    }
}